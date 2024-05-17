package _2024.creativeproject.persistence.repository;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import _2024.creativeproject.persistence.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<TodoEntity, Long> {
	List<TodoEntity> findByUserId(Long userId);
}
