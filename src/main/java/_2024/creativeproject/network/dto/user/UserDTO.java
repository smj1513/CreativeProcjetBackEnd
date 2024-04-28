package _2024.creativeproject.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private String responseMessage;
	private List<TodoDTO> todoList;
}
