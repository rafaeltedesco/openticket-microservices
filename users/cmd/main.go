package main

import (
	"net/http"
	db "openticket/internal/config"
	"openticket/internal/controllers"
	"openticket/internal/models"

	_ "github.com/lib/pq"
)

func main() {
	userModel := models.NewUserModel(db.NewPostgresDB())
	userController := controllers.NewUserController(userModel)

	http.HandleFunc("/users", userController.GetUsers)
	http.HandleFunc("/user/", userController.GetUserById)
	http.HandleFunc("/favicon.ico", func(w http.ResponseWriter, r *http.Request) {})

	http.ListenAndServe(":8080", nil)
}
