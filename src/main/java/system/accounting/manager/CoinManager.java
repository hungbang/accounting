package system.accounting.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import system.accounting.domain.Coin;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.repository.CoinRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by KAI on 4/22/18.
 */
@Component
public class CoinManager {

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getAllCoins(String username) throws CoinNotFoundException {

        List<Coin> coins =  coinRepository.findAllByUserId(username);
        if(coins.isEmpty())
            throw new CoinNotFoundException();

        return coins;

    }

    public Coin saveCoin(Coin coin) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        coin.setUserId(username);
        return coinRepository.save(coin);
    }
}
