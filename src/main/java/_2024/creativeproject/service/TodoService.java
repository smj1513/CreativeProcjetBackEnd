package _2024.creativeproject.service;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import _2024.creativeproject.persistence.entity.TodoEntity;
import _2024.creativeproject.persistence.entity.UserEntity;
import _2024.creativeproject.persistence.repository.ToDoRepository;
import _2024.creativeproject.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final ToDoRepository toDoRepository;
	private final UserRepository userRepository;

	@Transactional
	public List<TodoDTO> insert(TodoDTO todoDTO) throws IllegalArgumentException {
		Optional<UserEntity> user = userRepository.findByLoginId(todoDTO.getUserId());
		UserEntity user1 = user.orElseThrow(()->new IllegalArgumentException("사용자 정보가 없습니다."));
		TodoEntity todoEntity = TodoEntity.of(todoDTO, user1);
		List<TodoEntity> todoList = user1.getTodoList();
		todoList.add(todoEntity);
		toDoRepository.save(todoEntity);
		return todoList.stream().map(TodoDTO::from).toList();
	}

	@Transactional
	public List<TodoDTO> update(TodoDTO todoDTO) throws IllegalArgumentException {
		Optional<TodoEntity> todoEntity = toDoRepository.findById(todoDTO.getId());
		TodoEntity todo = todoEntity.orElseThrow(()->new IllegalArgumentException("해당되는 할 일 정보가 없습니다"));
		todo.setTitle(todoDTO.getTitle());
		todo.setContent(todoDTO.getContent());
		todo.setDueDate(todoDTO.getDueDate());
		todo.setIsCompleted(todoDTO.getIsCompleted());
		return toDoRepository.findByUserId(todo.getUser().getId()).stream().map(TodoDTO::from).toList();
	}

	@Transactional
	public List<TodoDTO> check(Long todoId) throws IllegalArgumentException {
		TodoEntity todo = toDoRepository.findById(todoId).orElseThrow(()->new IllegalArgumentException("해당되는 할 일 정보가 없습니다."));
		todo.setIsCompleted(!todo.getIsCompleted());
		List<TodoEntity> todoList = todo.getUser().getTodoList();
		return todoList.stream().map(TodoDTO::from).toList();
	}

	@Transactional
	public List<TodoDTO> delete(Long todoId) throws IllegalArgumentException{
		Optional<TodoEntity> todoEntity = toDoRepository.findById(todoId);
		TodoEntity todo = todoEntity.orElseThrow(()->new IllegalArgumentException("해당되는 할 일 정보가 없습니다."));
		toDoRepository.delete(todo);
		return toDoRepository.findByUserId(todo.getUser().getId()).stream().map(TodoDTO::from).toList();
	}

	public List<TodoDTO> getTodoList(String loginId) throws IllegalArgumentException{
		return userRepository
				.findByLoginId(loginId)
				.orElseThrow(()->new IllegalArgumentException("사용자 정보가 없습니다."))
				.getTodoList()
				.stream()
				.map(TodoDTO::from)
				.toList();
	}
}
