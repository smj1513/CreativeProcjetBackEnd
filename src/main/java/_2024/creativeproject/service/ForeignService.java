package _2024.creativeproject.service;

import _2024.creativeproject.network.dto.foreign.ExchangeResDTO;
import _2024.creativeproject.network.dto.foreign.ItemDTO;
import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.persistence.repository.CurrencyRepository;
import _2024.creativeproject.utils.Enum.CurrencyUnit;
import _2024.creativeproject.utils.api.SearchAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log4j2
@RequiredArgsConstructor
public class ForeignService {
	private final CurrencyRepository currencyRepository;
	private final SearchAPI searchApi;


	public int exchange(int price, CurrencyUnit currencyUnit) {
		Optional<List<Currency>> closestByRegisteredDate = currencyRepository.findClosestByRegisteredDate();
		AtomicInteger result = new AtomicInteger();
		closestByRegisteredDate.ifPresent(currencies -> {
			Optional<Currency> targetCurrency = currencies.stream().filter(thisCurrency -> {
				return thisCurrency.getCurrencyUnit().equals(currencyUnit);
			}).findFirst();
			targetCurrency.ifPresentOrElse(currency -> {
				double rate = currency.getDealBasR();
				if (currency.getCurrencyUnit().equals(CurrencyUnit.JPY) || currency.getCurrencyUnit().equals(CurrencyUnit.IDR)) {
					rate /= 100;
				}
				result.set((int) (rate * price));
			}, () -> {
				result.set(0);
			});
		});
		return result.get();
	}

	public List<ExchangeResDTO> getCurrencyList() {
		List<ExchangeResDTO> exchangeResDTOS = new ArrayList<>();
		currencyRepository.findClosestByRegisteredDate().ifPresent((currencyList) -> {
			currencyList.forEach(currency -> {
				exchangeResDTOS.add(ExchangeResDTO.from(currency));
			});
		});
		return exchangeResDTOS;
	}

	public List<ItemDTO> search(String itemName) throws JsonProcessingException {
		return searchApi.search(itemName);
	}


	/*public RateItemResDTO rateItemCalc(RateItemRequestDTO rateItemRequestDTO) throws IOException {
		String itemName = rateItemRequestDTO.getItemName();
		Integer price = rateItemRequestDTO.getPrice();
		CurrencyUnit currencyFromUser = rateItemRequestDTO.getCurrency();
		Optional<List<Currency>> exim = currencyRepository.findClosestByRegisteredDate();
		Optional<NaverShoppingDTO> search = naverShoppingApi.search(itemName);

		AtomicLong calcPrice = new AtomicLong();
		List<ItemDTO> itemDTOList = new ArrayList<>();

		exim.ifPresent(currencies -> {
			Optional<Currency> selectedCurrency = currencies.stream().filter((currency1) -> currencyFromUser.equals(currency1.getCurrencyUnit())).findFirst();
			selectedCurrency.ifPresent(currency -> {
				CurrencyUnit currencyUnit = currency.getCurrencyUnit();
				Double rate = currency.getDealBasR();
				if (currencyUnit.equals(CurrencyUnit.JPY) || currencyUnit.equals(CurrencyUnit.IDR)) {
					rate /= 100;
				}
				calcPrice.set((int) (rate * price));
			});
		});
		search.ifPresent((naverShoppingDTO -> {
			naverShoppingDTO.getItems().forEach(item -> {
				ItemDTO itemdto = ItemDTO.from(item);
				itemdto.setCalcPrice(Long.parseLong(item.getLprice()) - calcPrice.get());
				itemDTOList.add(itemdto);
			});
			itemDTOList.sort(Comparator.comparingInt(ItemDTO::getLowPrice));
		}));
		return RateItemResDTO.builder().calculatedPrice(calcPrice.get()).itemList(itemDTOList).build(); //TODO
	}
*/
}
