package models

type IModelCRUD interface {
	Create(data ...interface{}) (interface{}, error)
	Update(id string, data ...interface{}) (interface{}, error)
	Delete(id string) error
	IModelReader
}

type IModelReader interface {
	FindAll(page, pageSize int) ([]interface{}, error)
	FindById(id string) (interface{}, error)
}
