package system.accounting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import system.accounting.domain.mongo.CoinCollection;

import java.util.List;
import java.util.Optional;

/**
 * Created by KAI on 5/12/18.
 */
public interface CoinCollectionMongoRepository extends MongoRepository<CoinCollection, String> {
//    Optional<CoinCollection> findById(String id);
    Optional<List<CoinCollection>> findByUserId(String id);

}
