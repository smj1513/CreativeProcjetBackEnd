package _2024.creativeproject.network.dto.user;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import _2024.creativeproject.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private String id;
	private String name;
	private String responseMessage;
	private List<TodoDTO> todoList;

	public static UserDTO from(UserEntity user) {
		List<TodoDTO> todoList = new ArrayList<>();
		user.getTodoList().forEach((todo) -> {
			todoList.add(TodoDTO.from(todo));
		});
		return UserDTO.builder()
				.id(user.getLoginId())
				.name(user.getName())
				.todoList(todoList)
				.build();
	}

}
