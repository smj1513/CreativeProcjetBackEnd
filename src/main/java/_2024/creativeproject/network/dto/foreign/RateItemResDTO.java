package _2024.creativeproject.network.dto.foreign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateItemResDTO {
	private Long calculatedPrice;
	private List<ItemDTO> itemList;
}
