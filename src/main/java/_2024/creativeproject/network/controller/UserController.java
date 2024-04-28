package _2024.creativeproject.controller;

import _2024.creativeproject.annotation.QueryStringArgResolver;
import _2024.creativeproject.dto.user.JoinDTO;
import _2024.creativeproject.dto.user.LoginDTO;
import _2024.creativeproject.dto.user.UserDTO;
import _2024.creativeproject.exception.LoginInfoNotFoundException;
import _2024.creativeproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Log4j2
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/login")
	public ResponseEntity<UserDTO> login(@QueryStringArgResolver LoginDTO loginDTO) {
		ResponseEntity<UserDTO> response = null;
		try {
			UserDTO user = userService.login(loginDTO);
			user.setResponseMessage("정상적으로 로그인 되었습니다.");
			response = ResponseEntity.ok(user);
		} catch (LoginInfoNotFoundException e) {
			UserDTO userResponseDTO = new UserDTO();
			userResponseDTO.setResponseMessage(e.getMessage());
			response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userResponseDTO);
		}
		return response;
	}


	@PostMapping("/join")
	public ResponseEntity<String> join(@QueryStringArgResolver JoinDTO joinDTO) {
		ResponseEntity<String> response = null;
		try {
			userService.join(joinDTO);
			response = ResponseEntity.ok("회원가입에 성공하였습니다.");
		} catch (RuntimeException e) {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("회원 가입에 실패하였습니다. 사유 : " + e.getMessage());
		}
		return response;

	}
}

