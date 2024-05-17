package _2024.creativeproject.network.dto.domestic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceRequestDTO {
	private String xPos;
	private String yPos;
	private Integer contentTypeId;
}
