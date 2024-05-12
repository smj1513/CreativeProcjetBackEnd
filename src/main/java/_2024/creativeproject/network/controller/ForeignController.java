package _2024.creativeproject.network.controller;

import _2024.creativeproject.network.dto.foreign.ExchangeResDTO;
import _2024.creativeproject.network.dto.foreign.ItemDTO;
import _2024.creativeproject.service.ForeignService;
import _2024.creativeproject.utils.Enum.CurrencyUnit;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foreign")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class ForeignController {
	private final ForeignService foreignService;
	/*@GetMapping("/rateItem")
	public RateItemResDTO rateItem(@QueryStringArgResolver RateItemRequestDTO rateItemRequestDTO){
		try {
			return foreignService.rateItemCalc(rateItemRequestDTO);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}*/

	@GetMapping("/exchange")
	public ResponseEntity<Integer> exchange(@RequestParam int price, @RequestParam CurrencyUnit currency) {
		return ResponseEntity.ok(foreignService.exchange(price, currency));
	}

	@GetMapping("/currency")
	public List<ExchangeResDTO> currency() {
		log.info("currency get request");
		return foreignService.getCurrencyList();
	}

	@GetMapping("/search")
	public List<ItemDTO> search(@RequestParam String itemName) {
		try {
			return foreignService.search(itemName);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
