package _2024.creativeproject.service;

import _2024.creativeproject.util.Enum.CurrencyUnit;
import _2024.creativeproject.network.dto.RateItemReqestDTO;
import _2024.creativeproject.network.dto.RateItemResDTO;
import _2024.creativeproject.network.dto.ShoppingItemDTO;
import _2024.creativeproject.util.api.EximApi;
import _2024.creativeproject.util.api.NaverShopSearch;
import _2024.creativeproject.util.dto.Item;
import _2024.creativeproject.util.dto.KoreaEximDTO;
import _2024.creativeproject.util.dto.NaverShoppingDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OverseasService {

	private final EximApi eximApi;
	private final NaverShopSearch naverShoppingApi;

	public RateItemResDTO rateItemCalc(RateItemReqestDTO rateItemReqestDTO) throws JsonProcessingException {
		String itemName = rateItemReqestDTO.getItemName();
		Integer price = rateItemReqestDTO.getPrice();
		CurrencyUnit currency = rateItemReqestDTO.getCurrency();
		double calcPrice = 0;
		List<ShoppingItemDTO> sItemList = new ArrayList<>();
		Optional<KoreaEximDTO> koreaEximDTO = eximApi.getExim(currency);
		Optional<NaverShoppingDTO> search = naverShoppingApi.search(itemName);
		List<Item> items = null;
		if (koreaEximDTO.isPresent()) {
			KoreaEximDTO koreaEximDTO1 = koreaEximDTO.get();
			log.info(koreaEximDTO1);
			double rate = Double.parseDouble(koreaEximDTO1.getTts().replace(",",""));
			calcPrice = price * rate;
		}
		if(search.isPresent()){
			NaverShoppingDTO naverShoppingDTO = search.get();
			items = naverShoppingDTO.getItems();
		}
		return RateItemResDTO.builder().calculatedPrice(calcPrice).itemList(items).build(); //TODO
	}

}
