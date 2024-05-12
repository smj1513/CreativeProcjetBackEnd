package _2024.creativeproject.network.dto.foreign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EximDTO {

	private String curName; //국가 명
	private String dealBasR; // 매매기준율
}
