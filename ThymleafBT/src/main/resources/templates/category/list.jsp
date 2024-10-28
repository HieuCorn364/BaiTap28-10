<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html layout:decorate="~{layout/main}">
<head>
    <title>Danh sách Category</title>
</head>
<body>
<main>
    <form th:action="@{/categories}" method="get">
        <input type="text" name="keyword" th:value="${keyword}" placeholder="Tìm kiếm theo tên"/>
        <button type="submit">Tìm kiếm</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="category : ${categories.content}">
            <td th:text="${category.id}"></td>
            <td th:text="${category.name}"></td>
            <td th:text="${category.description}"></td>
            <td>
                <a th:href="@{/categories/edit/{id}(id=${category.id})}">Edit</a>
                <a th:href="@{/categories/delete/{id}(id=${category.id})}">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>

    <div>
        <a th:href="@{/categories?page=${categories.number - 1}}"
           th:if="${categories.hasPrevious()}">Previous</a>
        <span th:text="${categories.number + 1}"></span> / <span th:text="${categories.totalPages}"></span>
        <a th:href="@{/categories?page=${categories.number + 1}}"
           th:if="${categories.hasNext()}">Next</a>
    </div>
</main>
</body>
</html>
