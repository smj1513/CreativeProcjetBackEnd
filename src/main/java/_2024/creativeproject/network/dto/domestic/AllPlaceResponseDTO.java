package _2024.creativeproject.network.dto.domestic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllPlaceResponseDTO {
	private List<PlaceResponseDTO> tourList;
	private List<PlaceResponseDTO> sportsList;
	private List<PlaceResponseDTO> cultureList;
	private List<PlaceResponseDTO> accommodationList;
	private List<PlaceResponseDTO> eventList;
	private List<PlaceResponseDTO> walkList;
	private List<PlaceResponseDTO> shoppingList;
	private List<PlaceResponseDTO> restaurantList;
}
