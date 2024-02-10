package usecases

import (
	"openticket/internal/models"
)

type ShowUserByIdUseCase struct {
	userModel models.IModelReader
}

func NewShowUserByIdUseCase(userModel models.IModelReader) *ShowUserByIdUseCase {
	return &ShowUserByIdUseCase{
		userModel,
	}
}

func (u *ShowUserByIdUseCase) Execute(id string) (interface{}, error) {
	return u.userModel.FindById(id)
}
