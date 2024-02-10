package usecases

type IUseCase interface {
	Execute(data ...interface{}) (interface{}, error)
}
