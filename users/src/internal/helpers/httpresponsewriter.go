package helpers

import (
	"encoding/json"
	"net/http"
)

type HttpErrorResponse struct {
	Message string `json:"message"`
}

func WriteResponseError(w http.ResponseWriter, err error) {
	w.WriteHeader(http.StatusInternalServerError)
	json, err := json.Marshal(HttpErrorResponse{Message: err.Error()})
	if err != nil {
		w.Write([]byte(err.Error()))
		return
	}
	w.Write(json)
}

func WriteResponseSuccess(w http.ResponseWriter, data interface{}) {
	w.WriteHeader(http.StatusOK)
	json, err := json.Marshal(data)
	if err != nil {
		WriteResponseError(w, err)
		return
	}
	w.Write(json)
}
