package db

import (
	"database/sql"
	"log"
)

type IDb interface {
	GetConnection() *sql.DB
	CloseConnection()
}

type PostgresDB struct {
	Conn *sql.DB
}

func NewPostgresDB() IDb {
	return &PostgresDB{}
}

func (d *PostgresDB) GetConnection() *sql.DB {
	connStr := "user=postgres password=postgres dbname=users_db sslmode=disable"
	db, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Fatal(err)
	}
	d.Conn = db
	return d.Conn
}

func (d *PostgresDB) CloseConnection() {
	d.Conn.Close()
}
