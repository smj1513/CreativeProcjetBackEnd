package _2024.creativeproject.utils.api;

import _2024.creativeproject.network.dto.foreign.ItemDTO;
import _2024.creativeproject.utils.dto.foreign.NaverShoppingDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class NaverShoppingAPI implements SearchAPI {

	private static final String BASE_URL = "https://openapi.naver.com/v1/search/shop.json?query=";
	private static final String X_NAVER_CLIENT_ID = "n7DI1bzEdC_7mpiXUjRN";
	private static final String X_NAVER_CLIENT_SECRET = "zYR4N3xy2K";

	public List<ItemDTO> search(String query) throws JsonProcessingException {
		return search(query, 100);
	}

	private List<ItemDTO> search(String query, int display) throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		StringBuilder sb = new StringBuilder();

		headers.add("X-Naver-Client-Id", X_NAVER_CLIENT_ID);
		headers.add("X-Naver-Client-Secret", X_NAVER_CLIENT_SECRET);
		String body = "";

		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		ResponseEntity<NaverShoppingDTO> responseEntity = restTemplate
				.exchange(sb
								.append(BASE_URL)
								.append(query)
								.append("&display=")
								.append(display)
								.append("&sort=sim")
								.append("&exclude=cbshop")
								.toString()
						, HttpMethod.GET, requestEntity, NaverShoppingDTO.class);

		return Optional.of(responseEntity)
				.map(ResponseEntity::getBody)
				.map(NaverShoppingDTO::getItems)
				.map(list -> {
					return list.stream().map(ItemDTO::from).sorted(Comparator.comparingInt(ItemDTO::getLowPrice)).toList();
				})
				.orElse(null);
	}
}
