package _2024.creativeproject.utils.scheduler;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.persistence.repository.CurrencyRepository;
import _2024.creativeproject.utils.api.EximAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeRateScheduler {
	private final EximAPI eximApi;
	private final CurrencyRepository currencyRepository;

	@Scheduled(cron = "0 05 11 * * 1-5")
	public void saveExchangeRate() {
		try {
			Optional<List<Currency>> exim = eximApi.getExim();
			exim.ifPresent(currencyRepository::saveAll);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0 0/30 12-18 * * 1-5")
	@Transactional
	public void updateExchangeRate() {
		try {
			Optional<List<Currency>> apiCurrencyList = eximApi.getExim();
			Optional<List<Currency>> dbCurrencyList = currencyRepository.findByNowDate();
			dbCurrencyList.ifPresent((dbList) -> {
				apiCurrencyList.ifPresent(apiList -> {
					for (int i = 0; i < dbList.size(); i++) {
						Currency dbCurrency = dbList.get(i);
						Currency apiCurrency = apiList.get(i);
						dbCurrency.setCurrencyUnit(apiCurrency.getCurrencyUnit());
						dbCurrency.setTts(apiCurrency.getTts());
						dbCurrency.setTtb(apiCurrency.getTtb());
						dbCurrency.setDealBasR(apiCurrency.getDealBasR());
						dbCurrency.setRegisteredDate(apiCurrency.getRegisteredDate());
					}
				});
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
