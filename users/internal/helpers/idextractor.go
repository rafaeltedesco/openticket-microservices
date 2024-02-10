package helpers

import "net/http"

func GetIdFromRequest(r *http.Request) string {
	return r.URL.Path[len("/user/"):]
}
