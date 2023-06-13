package com.example.todoapp.service.Todos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.todoapp.model.Todo;

public interface ITodoService 
{
	public Todo createTodo(Todo todo);
	public Page<Todo> paginate(Pageable pageable);
	public Todo findTodoById(Long todoId);
	public Todo updateTodo(Long todoId, Todo todo);
	public ResponseEntity<?> deleteTodo(Long todoId);
	public List<Todo> findByTitle(String title);
	public List<Todo> fetchTodos(String title);
}
