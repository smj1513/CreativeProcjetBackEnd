package _2024.creativeproject.utils.Enum;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TourismType {
	ALL(0),
	TOURISM_DESTINATION(12),
	CULTURE_FACILITIES(14),
	FESTIVAL(15),
	TRAVEL_COURSE(25),
	LEISURE_SPORTS(28),
	ACCOMMODATION(38),
	RESTAURANT(39);

	int id;

	TourismType(int id) {
		this.id = id;
	}
	public static TourismType valueOf(int id){
		return Arrays.stream(TourismType.values())
				.filter((tourismType -> tourismType.id == id))
				.findFirst()
				.orElse(null);
	}


}
