package _2024.creativeproject.service;

import _2024.creativeproject.exception.AlreadyDataException;
import _2024.creativeproject.exception.LoginInfoNotFoundException;
import _2024.creativeproject.mapper.JoinMapper;
import _2024.creativeproject.network.dto.user.JoinDTO;
import _2024.creativeproject.network.dto.user.LoginDTO;
import _2024.creativeproject.network.dto.user.UserDTO;
import _2024.creativeproject.persistence.entity.UserEntity;
import _2024.creativeproject.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JoinMapper joinMapper;

	@Override
	public UserDTO login(LoginDTO loginDTO) throws LoginInfoNotFoundException {
		String id = loginDTO.getId();
		String pw = loginDTO.getPw();
		UserEntity user = userRepository.findByLoginId(id).orElseThrow(() -> new LoginInfoNotFoundException("일치하는 ID가 없습니다."));
		if (!passwordEncoder.matches(pw, user.getPassword())) {
			throw new LoginInfoNotFoundException("비밀번호가 일치하지 않습니다.");
		} else {
			UserDTO result = UserDTO.from(user);
			result.setResponseMessage("정상적으로 로그인 되었습니다.");
			return result;
		}
	}


	@Override
	public UserDTO join(JoinDTO joinDTO) throws AlreadyDataException {
		if (isDup(joinDTO.getId())) {
			throw new AlreadyDataException("이미 존재하는 ID 입니다.");
		} else {
			return UserDTO.from(userRepository.save(joinMapper.map(joinDTO)));
		}
	}

	@Override
	public boolean isDup(String id) {
		return userRepository.findByLoginId(id).isPresent();
	}

}
