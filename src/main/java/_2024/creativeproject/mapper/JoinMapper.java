package _2024.creativeproject.mapper;

import _2024.creativeproject.network.dto.user.JoinDTO;
import _2024.creativeproject.network.dto.user.UserDTO;
import _2024.creativeproject.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Qualifier("JoinMapper")
@RequiredArgsConstructor
public class JoinMapper implements Mapper<JoinDTO, UserEntity> {

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserEntity map(JoinDTO joinDTO) {
		return UserEntity.builder()
				.loginId(joinDTO.getId())
				.name(joinDTO.getName())
				.todoList(new ArrayList<>())
				.password(passwordEncoder.encode(joinDTO.getPw()))
				.build();
	}


}
