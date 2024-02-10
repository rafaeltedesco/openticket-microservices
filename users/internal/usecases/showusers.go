package usecases

import (
	"openticket/internal/models"
)

type ShowUsersUseCase struct {
	userModel models.IModelReader
}

func NewShowUsersUseCase(userModel models.IModelReader) *ShowUsersUseCase {
	return &ShowUsersUseCase{
		userModel,
	}
}

func (u *ShowUsersUseCase) Execute(page int, pageSize int) (interface{}, error) {
	return u.userModel.FindAll(page, pageSize)
}
