package _2024.creativeproject.utils.api;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.persistence.repository.CurrencyRepository;
import _2024.creativeproject.utils.Enum.CurrencyUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class EximAPITest {

	private static final Logger log = LoggerFactory.getLogger(EximAPITest.class);
	@Autowired
	EximAPI eximApi;

	@Autowired
	CurrencyRepository currencyRepository;


	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getExim() throws IOException, InterruptedException {
		Optional<List<Currency>> exim = eximApi.getExim();
		exim.ifPresent(currencies -> {
			log.info(currencies.toString());
			currencyRepository.saveAll(currencies);
		});
	}

	@Test
	void 환율정보요청(){
		try {
			Optional<List<Currency>> exim = eximApi.getExim();
			exim.ifPresent(currencies -> {
				log.info("URL : {}", eximApi.getUrl());
				currencies.forEach(currency -> {
					log.info(currency.toString());
				});
			});
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Test
	void findUnit(){
		Optional<Currency> byCurrencyUnit = currencyRepository.findByCurrencyUnit(CurrencyUnit.JPY);

		Assertions.assertThat(byCurrencyUnit).isPresent();
	}

	@Test
	void findClosestByRegisteredDate(){
		Optional<List<Currency>> closestByRegisteredDate = currencyRepository.findClosestByRegisteredDate();
		List<Currency> currencies = closestByRegisteredDate.get();

		Assertions.assertThat(currencies.size()).isEqualTo(23);
	}
}