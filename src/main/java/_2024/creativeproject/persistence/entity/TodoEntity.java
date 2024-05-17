package _2024.creativeproject.persistence.entity;

import _2024.creativeproject.network.dto.todo.TodoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@Getter
@Setter
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String content;

	@Column
	private Boolean isCompleted;

	@CreatedDate
	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDate dueDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public static TodoEntity of(TodoDTO todoDTO, UserEntity user){
		return TodoEntity.builder()
				.title(todoDTO.getTitle())
				.content(todoDTO.getContent())
				.dueDate(todoDTO.getDueDate())
				.createdDate(LocalDateTime.now())
				.user(user)
				.isCompleted(todoDTO.getIsCompleted()).build();
	}

	@Override
	public String toString() {
		return "TodoEntity{" +
				"id=" + id +
				", text='" + content + '\'' +
				", dueDate=" + dueDate +
				'}';
	}
}
