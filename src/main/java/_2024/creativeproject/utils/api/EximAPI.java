package _2024.creativeproject.utils.api;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.utils.dto.foreign.KoreaEximDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Log4j2
@RequiredArgsConstructor
public class EximAPI {

	@Value("${URL}")
	private String URL;
	@Value("${AUTH_KEY}")
	private String AUTH_KEY;
	private static final int MAX_RETRIES = 5;
	private final ObjectMapper om;

	public String getUrl() {
		return URL;
	}


	public Optional<List<Currency>> getExim() throws IOException, InterruptedException {
		int attempt = 0;
		while (attempt < MAX_RETRIES) {
			try {
				URL url = new URL(URL);
				KoreaEximDTO[] koreaEximDTOS = om.readValue(url, KoreaEximDTO[].class);
				if (koreaEximDTOS != null) {
					List<Currency> currencies = new ArrayList<>();
					for (KoreaEximDTO exim : koreaEximDTOS) {
						currencies.add(Currency.of(exim, LocalDate.now()));
					}
					return Optional.of(currencies);
				} else {
					return Optional.empty();
				}
			} catch (Exception e) {
				attempt++;
				if (attempt >= MAX_RETRIES) {
					throw e;
				}
				// 잠시 대기 후 재시도
				Thread.sleep(1000);
			}
		}
		throw new IOException("Failed to fetch data after " + MAX_RETRIES + " attempts");
	}
}
