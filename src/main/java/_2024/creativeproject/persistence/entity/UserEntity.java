package _2024.creativeproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String loginId;

	private String password;

	@OneToMany(mappedBy = "user")
	private List<TodoEntity> todoList = new ArrayList<>();

	@Override
	public String toString() {
		return "name : " + name + "userId : " + loginId + "password" + password + "TodoList : " + Arrays.toString(todoList.toArray());
	}
}
