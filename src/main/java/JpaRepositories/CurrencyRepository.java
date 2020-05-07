package JpaRepositories;

import com.cherries.exchange.demo.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
