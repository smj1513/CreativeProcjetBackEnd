package _2024.creativeproject.network.dto.foreign;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.utils.Enum.CurrencyUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResDTO {
	private double dealBasR;
	private CurrencyUnit currencyUnit;
	private LocalDate registeredDate;

	public static ExchangeResDTO from(Currency currency) {
		return ExchangeResDTO.builder()
				.dealBasR(currency.getDealBasR())
				.currencyUnit(currency.getCurrencyUnit())
				.registeredDate(currency.getRegisteredDate())
				.build();
	}
}
