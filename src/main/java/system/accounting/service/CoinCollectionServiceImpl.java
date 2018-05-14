package system.accounting.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.accounting.domain.Coin;
import system.accounting.domain.mongo.CoinCollection;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinRequestBody;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;
import system.accounting.properties.AccountantAppProperties;
import system.accounting.repository.CoinCollectionMongoRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by KAI on 5/13/18.
 */

@Service
public class CoinCollectionServiceImpl implements CoinService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CoinCollectionServiceImpl.class);

    @Autowired
    private CoinCollectionMongoRepository coinCollectionMongoRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private AccountantAppProperties accountantAppProperties;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <T> T getCoinsSupported() throws IOException, CoinsDataNotFoundException {
        return null;
    }

    @Override
    public CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException {
        return null;
    }

    @Override
    public CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        return null;
    }

    @Override
    public List<CoinCollection> getAllCoins() throws CoinNotFoundException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return coinCollectionMongoRepository.findByUserId(username).get();
    }

    @Override
    public List<CoinCollection> saveAllCoins(CoinRequestBody coinRequestBody) {
        LOGGER.debug("Saving coins to mongodb");
        List<CoinRequestBody.CoinData> coinDatas = coinRequestBody.getCoinDatas();
        Objects.requireNonNull(coinDatas, "CoinData must be not null");
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "coins");
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        coinDatas.stream().forEach(coinData -> {
            CoinCollection coin = this.getCoin(coinData);

            if (coinData.getId() == null) {
                LOGGER.debug("inserting coins to mongodb === " + coin);
                coin.setId(UUID.randomUUID().toString());
                coin.setUserId(username);
                coinCollectionMongoRepository.save(coin);

            } else {
                LOGGER.debug("updating coins to mongodb === " + coin);
                Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(coin.getId()));
                Update update = new Update();
                update.set("userId", username);
                update.set("coinName", coin.getCoinName());
                update.set("amount", coin.getAmount());
                update.set("priceBuy", coin.getPriceBuy());
                bulkOperations.updateOne(query, update).execute();
            }
        });
        LOGGER.debug("Saved coins to mongodb");

        List<CoinCollection> coinCollections = coinCollectionMongoRepository.findByUserId(username).get();
        simpMessagingTemplate.convertAndSend(accountantAppProperties.getAccountant().getWss().getStock().getUserscoinnew(),coinCollections);

        return coinCollectionMongoRepository.findByUserId(username).get();
    }

    private CoinCollection getCoin(CoinRequestBody.CoinData coinData) {
        CoinCollection coin = dozerBeanMapper.map(coinData, CoinCollection.class);
        coin.setId(coinData.getId());
        return coin;
    }

    @Override
    public void delete(String id) {
        Optional<CoinCollection> coinCollectionOptional = coinCollectionMongoRepository.findById(id);
        if(coinCollectionOptional.isPresent())
            coinCollectionMongoRepository.delete(coinCollectionOptional.get());
    }
}
