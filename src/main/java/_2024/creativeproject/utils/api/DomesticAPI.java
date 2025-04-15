package _2024.creativeproject.utils.api;

import _2024.creativeproject.utils.dto.domestic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DomesticAPI {
	private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/";
	@Value("${AUTH_KEY_ENCODING}")
	private String AUTHENTICATION_KEY_ENCODING;
	@Value("${AUTH_KEY_DECODING}")
	private String AUTHENTICATION_KEY_DECODING;
	private static final Integer MAX_RADIUS = 7000;
	private final ObjectMapper om;

	private String getDefaultUrl(int rowCount, int pageNum, String xPos, String yPos, int radius) {
		StringBuilder builder = new StringBuilder();
		return builder.append(BASE_URL)
				.append("locationBasedList1?")
				.append("serviceKey=").append(AUTHENTICATION_KEY_ENCODING)
				.append("&numOfRows=").append(rowCount)
				.append("&pageNo=").append(pageNum)
				.append("&_type=json")
				.append("&MobileOS=ETC")
				.append("&MobileApp=TravelSupporter")
				.append("&listYN=Y")
				.append("&arrange=R")
				.append("&mapX=").append(xPos)
				.append("&mapY=").append(yPos)
				.append("&radius=").append(radius).toString();
	}

	public String getDefaultUrl(String xPos, String yPos) {
		return getDefaultUrl(10000, 1, xPos, yPos, MAX_RADIUS);
	}

	public String getContentUrl(String xPos, String yPos, int contentType) {
		return contentType == 0 ? getDefaultUrl(xPos, yPos) : getDefaultUrl(xPos, yPos) + "&contentTypeId=" + contentType;
	}


	public List<Item> get(String xPos, String yPos, int contentType) throws IOException, IllegalArgumentException {
		URL url = new URL(getContentUrl(xPos, yPos, contentType));
		return Optional.ofNullable(om.readValue(url, TourismDTO.class))
				.map(TourismDTO::getResponse)
				.map(Response::getBody)
				.map(Body::getItems)
				.map(Items::getItem)
				.orElse(null);
	}
}
