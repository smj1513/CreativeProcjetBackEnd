package _2024.creativeproject.utillity.api;

import _2024.creativeproject.Enum.CurrencyUnit;
import _2024.creativeproject.utillity.dto.KoreaEximDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Component
@Log4j2
@RequiredArgsConstructor
public class EximApi{

	public static final Integer KOREA_EXIM = 1000;
	private static final String URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
	private static final String AUTH_KEY = "YeCLP6lJrEirQ72gSS1YZ3XZkff1iHaF";
	private final ObjectMapper om;

	private String nowDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(LocalDate.now());
	}

	private String getUrl() {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(URL)
				.append("?authkey=")
				.append(AUTH_KEY)
				.append("&searchdate=")
				.append("20240404") //nowDate로 변경
				.append("&data=AP01");
		return urlBuilder.toString();
	}

	public Optional<KoreaEximDTO> getExim(CurrencyUnit currency) {
		Optional<KoreaEximDTO> result = Optional.empty();
		try {
			URL url = new URL(getUrl());
			List<KoreaEximDTO> koreaEximDTOList = List.of(om.readValue(url, KoreaEximDTO[].class));
			result = koreaEximDTOList.stream().filter((exim) ->
					exim.getCurUnit().equals(currency.getValue())).findFirst();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return result;
	}
}
