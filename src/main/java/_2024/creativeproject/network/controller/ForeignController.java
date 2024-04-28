package _2024.creativeproject.network.controller;

import _2024.creativeproject.network.dto.RateItemReqestDTO;
import _2024.creativeproject.network.dto.RateItemResDTO;
import _2024.creativeproject.service.OverseasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/overseas")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class OverseasController {
	private final OverseasService overseasService;

	@PostMapping("/rateItem")
	public RateItemResDTO rateItem(@RequestBody RateItemReqestDTO rateItemReqestDTO){
		log.info(rateItemReqestDTO);

		RateItemResDTO rateItemResDTO = null;
		try {
			rateItemResDTO = overseasService.rateItemCalc(rateItemReqestDTO);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		log.info(rateItemResDTO);
		return rateItemResDTO;
	}
}
