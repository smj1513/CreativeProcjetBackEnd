package _2024.creativeproject.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JoinDTO {

	private String name;
	private String id;
	private String pw;
}
