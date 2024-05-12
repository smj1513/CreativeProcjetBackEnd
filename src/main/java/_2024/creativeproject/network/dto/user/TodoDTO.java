package _2024.creativeproject.network.dto.user;


import _2024.creativeproject.persistence.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDTO {
	private Integer id;
	private String title;
	private String content;
	private String userId;
	private Boolean isCompleted;
	private LocalDateTime createdDate;
	private LocalDateTime dueDate;

	public static TodoDTO from(TodoEntity todo){ //정적 팩토리 메서드
		return TodoDTO.builder()
				.id(todo.getId())
				.title(todo.getTitle())
				.content(todo.getContent())
				.userId(todo.getUser().getLoginId())
				.isCompleted(todo.getIsCompleted())
				.createdDate(todo.getCreatedDate())
				.dueDate(todo.getDueDate())
				.build();
	}
}
