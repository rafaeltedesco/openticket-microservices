package controllers

import (
	"net/http"
	"openticket/internal/helpers"
	"openticket/internal/models"
	"openticket/internal/usecases"
)

type UserController struct {
	userModel models.IModelReader
}

func NewUserController(userModel models.IModelReader) *UserController {
	return &UserController{
		userModel,
	}
}

func (uc *UserController) GetUsers(w http.ResponseWriter, r *http.Request) {

	page, pageSize := helpers.ParsePaginationParams(r)

	showUserUseCase := usecases.NewShowUsersUseCase(uc.userModel)
	users, err := showUserUseCase.Execute(page, pageSize)
	if err != nil {
		helpers.WriteResponseError(w, err)
		return
	}
	helpers.WriteResponseSuccess(w, users)
}

func (uc *UserController) GetUserById(w http.ResponseWriter, r *http.Request) {
	id := helpers.GetIdFromRequest(r)
	showUserByIdUseCase := usecases.NewShowUserByIdUseCase(uc.userModel)
	user, err := showUserByIdUseCase.Execute(id)
	if err != nil {
		helpers.WriteResponseError(w, err)
		return
	}
	helpers.WriteResponseSuccess(w, user)
}
