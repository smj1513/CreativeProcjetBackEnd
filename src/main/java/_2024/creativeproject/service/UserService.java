package _2024.creativeproject.service;

import _2024.creativeproject.network.dto.user.JoinDTO;
import _2024.creativeproject.network.dto.user.LoginDTO;
import _2024.creativeproject.network.dto.user.UserDTO;

public interface UserService {

	UserDTO login(LoginDTO loginDTO);

	UserDTO join(JoinDTO joinDTO);

	boolean isDup(String id);
}
