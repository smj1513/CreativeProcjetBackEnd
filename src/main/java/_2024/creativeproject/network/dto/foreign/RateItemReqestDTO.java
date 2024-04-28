package _2024.creativeproject.network.dto;

import _2024.creativeproject.util.Enum.CurrencyUnit;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RateItemReqestDTO {
	private String itemName;
	private Integer price;
	private CurrencyUnit currency;
}
