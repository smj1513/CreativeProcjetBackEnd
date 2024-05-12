package _2024.creativeproject.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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
	private LocalDateTime dueDate;

	@ManyToOne
	@JoinColumn
	private UserEntity user;

	@Override
	public String toString() {
		return "TodoEntity{" +
				"id=" + id +
				", text='" + content + '\'' +
				", dueDate=" + dueDate +
				'}';
	}
}
