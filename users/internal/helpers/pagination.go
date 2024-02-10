package helpers

import (
	"net/http"
	"strconv"
)

func ParsePaginationParams(r *http.Request) (int, int) {
	pageParam := r.URL.Query().Get("page")
	pageSizeParam := r.URL.Query().Get("pageSize")

	page := 1
	pageSize := 10

	if pageParam != "" {
		pageInt, err := strconv.Atoi(pageParam)
		if err == nil && pageInt > 0 {
			page = pageInt
		}
	}

	if pageSizeParam != "" {
		pageSizeInt, err := strconv.Atoi(pageSizeParam)
		if err == nil && pageSizeInt > 0 {
			pageSize = pageSizeInt
		}
	}

	return page, pageSize
}
