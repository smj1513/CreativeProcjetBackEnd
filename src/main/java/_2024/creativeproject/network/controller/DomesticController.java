package _2024.creativeproject.network.controller;

import _2024.creativeproject.config.annotation.QueryStringArgResolver;
import _2024.creativeproject.network.dto.domestic.PlaceDTO;
import _2024.creativeproject.network.dto.domestic.PlaceRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/domestic")
@RequiredArgsConstructor
public class DomesticController {

	@GetMapping("/place")
	public List<PlaceDTO> place(@QueryStringArgResolver PlaceRequestDTO request) {
		return null;
	}
}
