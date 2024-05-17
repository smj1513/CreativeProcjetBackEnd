package _2024.creativeproject.network.controller;

import _2024.creativeproject.config.annotation.QueryStringArgResolver;
import _2024.creativeproject.network.dto.domestic.AllPlaceResponseDTO;
import _2024.creativeproject.network.dto.domestic.PlaceResponseDTO;
import _2024.creativeproject.network.dto.domestic.PlaceRequestDTO;
import _2024.creativeproject.service.DomesticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/domestic")
@RequiredArgsConstructor
public class DomesticController {
	private final DomesticService domesticService;

	@GetMapping("/place")
	public ResponseEntity<List<PlaceResponseDTO>> place(@RequestParam String xPos,
	                                                   @RequestParam String yPos,
	                                                   @RequestParam Integer contentTypeId) {
		try {
			//카카오 맵과 관광정보 서비스 조회 x,y좌표를 반대로 사용함
			return ResponseEntity.ok(domesticService.placeSearch(yPos,xPos,contentTypeId));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/allplace")
	public ResponseEntity<AllPlaceResponseDTO> allPlace(@RequestParam String xPos,
	                                                    @RequestParam String yPos){
		try {
			return ResponseEntity.ok(domesticService.allPlace(yPos, xPos));
		}catch (IOException e){
			log.error(e.getMessage());
		}
		return ResponseEntity.noContent().build();
	}
}
