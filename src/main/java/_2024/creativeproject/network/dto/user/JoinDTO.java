package _2024.creativeproject.network.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinDTO {
	private String name;
	private String id;
	private String pw;

}
