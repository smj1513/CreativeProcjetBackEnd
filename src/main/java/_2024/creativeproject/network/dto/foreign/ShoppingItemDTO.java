package _2024.creativeproject.network.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingItemDTO {
	private String itemName;
	private Integer itemPrice;
	private String sellerUrl;
	private String imgUrl;
}
