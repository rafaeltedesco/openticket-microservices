package models

import (
	"database/sql"
	"errors"
	db "openticket/src/internal/config"
	"openticket/src/internal/dtos"
)

type UserModel struct {
	db db.IDb
}

func NewUserModel(db db.IDb) IModelReader {
	return &UserModel{
		db,
	}
}

func (m *UserModel) FindAll(page, pageSize int) ([]interface{}, error) {
	conn := m.db.GetConnection()
	stmt, err := conn.Prepare("SELECT * FROM users LIMIT $1 OFFSET $2")
	if err != nil {
		return nil, err
	}

	rows, err := stmt.Query(pageSize, (page-1)*pageSize)

	if err != nil {
		return nil, err
	}

	defer rows.Close()
	defer m.db.CloseConnection()

	var users []interface{}
	for rows.Next() {
		var id, username, email, role string
		err := rows.Scan(&id, &username, &email, &role)
		if err != nil {
			return nil, err
		}
		users = append(users, &dtos.CreatedUserDTO{
			ID:       id,
			Username: username,
			Email:    email,
		})
	}
	return users, nil
}

func (m *UserModel) FindById(id string) (interface{}, error) {
	conn := m.db.GetConnection()
	stmt, err := conn.Prepare("SELECT * FROM users WHERE id = $1")
	if err != nil {
		return nil, err
	}

	row := stmt.QueryRow(id)

	defer m.db.CloseConnection()

	var username, email, password string
	err = row.Scan(&id, &username, &email, &password)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("User not found")
		}
		return nil, err
	}

	return &dtos.CreatedUserDTO{
		ID:       id,
		Username: username,
		Email:    email,
	}, nil
}
