package _2024.creativeproject.persistence.repository;

import _2024.creativeproject.persistence.entity.Currency;
import _2024.creativeproject.utils.Enum.CurrencyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	Optional<Currency> findByCurrencyUnit(CurrencyUnit currencyUnit);

	@Query(value = """
			SELECT * FROM creative.currency
			WHERE ABS(datediff(registered_date, current_date())) = 
			(SELECT MIN(ABS(datediff(registered_date, current_date()))) FROM currency)
			ORDER BY registered_date DESC
			""", nativeQuery = true)
	Optional<List<Currency>> findClosestByRegisteredDate();


	@Query(value = """
			SELECT * FROM creative.currency
			WHERE registered_date = current_date()
			""", nativeQuery = true)
	Optional<List<Currency>> findByNowDate();
}