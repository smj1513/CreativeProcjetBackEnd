package _2024.creativeproject.network.controller;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import _2024.creativeproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoList")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class TodoController {

	private final TodoService todoService;

	@GetMapping
	public ResponseEntity<List<TodoDTO>> findAll(@RequestParam String loginId) {
		log.info(loginId);
		return ResponseEntity.ok(todoService.getTodoList(loginId));
	}

	@PostMapping
	public List<TodoDTO> insert(@RequestBody TodoDTO todoDTO) {
		return todoService.insert(todoDTO);
	}

	@DeleteMapping("/{id}")
	public List<TodoDTO> delete(@PathVariable Long id) {
		return todoService.delete(id);
	}

	@PatchMapping("/{id}")
	public List<TodoDTO> complete(@PathVariable Long id) {
		return todoService.check(id);
	}

	@PatchMapping
	public List<TodoDTO> update(@RequestBody TodoDTO todoDTO) {
		return todoService.update(todoDTO);
	}
}
