package system.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.accounting.domain.Coin;

import java.util.List;

/**
 * Created by KAI on 4/22/18.
 */
public interface CoinRepository  extends JpaRepository<Coin, String>{


    List<Coin> findAllByUserId(String username);
}
