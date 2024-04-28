package _2024.creativeproject.network.dto;

import _2024.creativeproject.util.dto.Item;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RateItemResDTO {
	private Double calculatedPrice;
	private List<Item> itemList;
}
