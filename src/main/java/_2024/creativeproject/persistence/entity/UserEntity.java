package _2024.creativeproject.persistence.entity;

import _2024.creativeproject.network.dto.user.JoinDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String loginId;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<TodoEntity> todoList;

	@Override
	public String toString() {
		return "name : " + name + "userId : " + loginId + "password" + password + "TodoList : " + Arrays.toString(todoList.toArray());
	}
}
