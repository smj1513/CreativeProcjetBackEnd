package _2024.creativeproject.network.dto.foreign;

import _2024.creativeproject.utils.Enum.CurrencyUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateItemRequestDTO {
	private String itemName;
	private Integer price;
	private CurrencyUnit currency;
}
