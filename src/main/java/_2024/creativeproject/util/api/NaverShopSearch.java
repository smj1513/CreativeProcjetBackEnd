package _2024.creativeproject.utillity.api;

import _2024.creativeproject.utillity.dto.NaverShoppingDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class NaverShopSearch {

	private static final String URL = "https://openapi.naver.com/v1/search/shop.json?query=";
	private static final String X_NAVER_CLIENT_ID = "n7DI1bzEdC_7mpiXUjRN";
	private static final String X_NAVER_CLIENT_SECRET = "zYR4N3xy2K";
	private final ObjectMapper objectMapper;

	public Optional<NaverShoppingDTO> search(String query) throws JsonProcessingException {
		return search(query,10);
	}

	public Optional<NaverShoppingDTO> search(String query, int display) throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		StringBuilder sb = new StringBuilder();

		headers.add("X-Naver-Client-Id", X_NAVER_CLIENT_ID);
		headers.add("X-Naver-Client-Secret", X_NAVER_CLIENT_SECRET);
		String body ="";

		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		ResponseEntity<NaverShoppingDTO> responseEntity = restTemplate
				.exchange(sb
						.append(URL)
						.append(query)
						.append("display=")
						.append(display)
						.toString()
						, HttpMethod.GET, requestEntity, NaverShoppingDTO.class);
		int statusCode = responseEntity.getStatusCode().value();
		return Optional.ofNullable(responseEntity.getBody());
	}
}
