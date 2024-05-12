package _2024.creativeproject.persistence.entity;

import _2024.creativeproject.utils.Enum.CurrencyUnit;
import _2024.creativeproject.utils.dto.foreign.KoreaEximDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private CurrencyUnit currencyUnit;

	private Double dealBasR;

	private Double tts;

	private Double ttb;

	private LocalDate registeredDate;

	public static Currency of(KoreaEximDTO koreaEximDTO, LocalDate registeredDate) {
		return Currency.builder()
				.currencyUnit(CurrencyUnit.valueOf(koreaEximDTO.getCurUnit().replace("(100)", "")))
				.dealBasR(Double.valueOf(koreaEximDTO.getDealBasR().replace(",", "")))
				.ttb(Double.valueOf(koreaEximDTO.getTtb().replace(",", "")))
				.tts(Double.valueOf(koreaEximDTO.getTts().replace(",", "")))
				.registeredDate(registeredDate)
				.build();

	}

}
