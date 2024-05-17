package _2024.creativeproject.network.controller;

import _2024.creativeproject.config.annotation.QueryStringArgResolver;
import _2024.creativeproject.network.dto.user.JoinDTO;
import _2024.creativeproject.network.dto.user.LoginDTO;
import _2024.creativeproject.network.dto.user.UserDTO;
import _2024.creativeproject.exception.LoginInfoNotFoundException;
import _2024.creativeproject.service.UserService;
import lombok.Getter;
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
			response = ResponseEntity.ok(userService.login(loginDTO));
		} catch (LoginInfoNotFoundException e) {
			UserDTO userResponseDTO = new UserDTO();
			userResponseDTO.setResponseMessage(e.getMessage());
			response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userResponseDTO);
		}
		return response;
	}

	@GetMapping("/dupCheck")
	@ResponseStatus(code = HttpStatus.OK)
	public Boolean dupCheck(@RequestParam String userId){
		return userService.isDup(userId);
	}


	@PostMapping("/join")
	public ResponseEntity<UserDTO> join(@RequestBody JoinDTO joinDTO) {
		ResponseEntity<UserDTO> response = null;
		try {
			UserDTO user = userService.join(joinDTO);
			user.setResponseMessage("회원가입에 성공하였습니다.");
			response = ResponseEntity.ok(user);
		} catch (RuntimeException e) {
			response = ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(UserDTO
							.builder()
							.responseMessage("회원 가입에 실패하였습니다. 사유 : " + e.getMessage())
							.build());
		}
		return response;
	}
}

