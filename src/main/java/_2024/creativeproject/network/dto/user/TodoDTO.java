package _2024.creativeproject.dto.user;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDTO {
	private String text;
	private LocalDateTime createdDate;
	private LocalDateTime dueDate;

}
