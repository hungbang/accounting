package system.accounting.manager;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.accounting.domain.Coin;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.repository.CoinRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

/**
 * Created by KAI on 4/22/18.
 */
@Service
@Transactional
public class CoinManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(CoinManager.class);

    @Autowired
    private CoinRepository coinRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Coin> getAllCoins(String username) throws CoinNotFoundException {
        List<Coin> coins = coinRepository.findAllByUserId(username);
        if (coins.isEmpty())
            throw new CoinNotFoundException();
        return coins;
    }


    public Coin saveCoin(Coin coin) {
        return coinRepository.saveAndFlush(coin);
    }


    public Coin bulkSaveOrUpdate(Coin coin) {
        if (Strings.isNullOrEmpty(coin.getId()))
            return saveCoin(coin);

        else {
            Coin coinSaved = em.find(Coin.class, coin.getId());
            LOGGER.info("Detach Coin entity");
            em.flush();
            em.detach(coinSaved);
            LOGGER.info("Updating Coin entity");
            Query query = em.createNativeQuery("update accountant.coin set amount = :amount , code_name = :coin_name , price_buy = :price_buy " +
                    ", last_updated_at = :last_updated_at , version = version + 1 where id = :id");
            query.setParameter("amount", coin.getAmount());
            query.setParameter("coin_name", coin.getCoinName());
            query.setParameter("price_buy", coin.getPriceBuy());
            query.setParameter("last_updated_at", Calendar.getInstance().getTime());
            query.setParameter("id", coinSaved.getId());

            query.executeUpdate();
            return em.find(Coin.class, coin.getId());
        }
    }
}
