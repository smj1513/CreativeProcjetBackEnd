package _2024.creativeproject.service;

import _2024.creativeproject.network.dto.domestic.AllPlaceResponseDTO;
import _2024.creativeproject.network.dto.domestic.PlaceResponseDTO;
import _2024.creativeproject.utils.api.DomesticAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DomesticService {
	private final DomesticAPI domesticAPI;

	public List<PlaceResponseDTO> placeSearch(String xPos, String yPos, Integer contentTypeId) throws IOException {
		return domesticAPI.get(xPos, yPos, contentTypeId)
				.stream()
				.map(PlaceResponseDTO::from)
				.toList();
	}

	public AllPlaceResponseDTO allPlace(String xPos, String yPos) throws IOException {
		List<PlaceResponseDTO> allList = domesticAPI.get(xPos, yPos, 0).stream().map(PlaceResponseDTO::from).toList();
		Map<Integer, List<PlaceResponseDTO>> categorizedPlaces = allList.stream()
				.collect(Collectors.groupingBy(PlaceResponseDTO::getContentTypeId));

		return AllPlaceResponseDTO.builder()
				.accommodationList(categorizedPlaces.getOrDefault(32, new ArrayList<>()))
				.cultureList(categorizedPlaces.getOrDefault(14, new ArrayList<>()))
				.eventList(categorizedPlaces.getOrDefault(15, new ArrayList<>()))
				.restaurantList(categorizedPlaces.getOrDefault(39, new ArrayList<>()))
				.shoppingList(categorizedPlaces.getOrDefault(38, new ArrayList<>()))
				.sportsList(categorizedPlaces.getOrDefault(28, new ArrayList<>()))
				.tourList(categorizedPlaces.getOrDefault(12, new ArrayList<>()))
				.walkList(categorizedPlaces.getOrDefault(25, new ArrayList<>()))
				.build();
	}
}
