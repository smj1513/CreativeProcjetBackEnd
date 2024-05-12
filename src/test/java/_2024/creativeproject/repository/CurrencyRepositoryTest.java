package _2024.creativeproject.repository;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.persistence.repository.CurrencyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class CurrencyRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CurrencyRepositoryTest.class);
	@Autowired
	CurrencyRepository currencyRepository;

	@Test
	void test(){
		Optional<List<Currency>> nowDate = currencyRepository.findByNowDate();
		nowDate.ifPresent(list->{
			list.forEach(cur->{
				log.info(cur.toString());
			});
		});
		Assertions.assertThat(nowDate).isPresent();
	}

}