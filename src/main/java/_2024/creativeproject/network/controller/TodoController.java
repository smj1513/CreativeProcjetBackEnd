package _2024.creativeproject.network.controller;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import _2024.creativeproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todoList")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class TodoController {

	private final TodoService todoService;

	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam String loginId) {
		try {
			return ResponseEntity.ok(todoService.getTodoList(loginId));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody TodoDTO todoDTO) {
		try {
			return ResponseEntity.ok(todoService.insert(todoDTO));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(todoService.delete(id));
		}catch (IllegalArgumentException e){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> complete(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(todoService.check(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
		}
	}

	@PatchMapping
	public ResponseEntity<?> update(@RequestBody TodoDTO todoDTO) {
		try {
			return ResponseEntity.ok(todoService.update(todoDTO));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
		}
	}
}
