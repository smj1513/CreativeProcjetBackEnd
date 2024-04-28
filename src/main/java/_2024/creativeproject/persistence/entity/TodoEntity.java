package _2024.creativeproject.entity;

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
	private Integer id;

	private String text;

	@CreatedDate
	@Column
	private LocalDateTime createdDate;
	@Column
	private LocalDateTime dueDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Override
	public String toString() {
		return "TodoEntity{" +
				"id=" + id +
				", text='" + text + '\'' +
				", dueDate=" + dueDate +
				'}';
	}
}
