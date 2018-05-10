package system.accounting.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import system.accounting.domain.Coin;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.repository.CoinRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by KAI on 4/22/18.
 */
@Component
public class CoinManager {

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getAllCoins(String username) throws CoinNotFoundException {
        List<Coin> coins = coinRepository.findAllByUserId(username);
        if (coins.isEmpty())
            throw new CoinNotFoundException();
        return coins;
    }

    @Transactional
    public Coin saveCoin(Coin coin) {
        return coinRepository.save(coin);
    }
}
