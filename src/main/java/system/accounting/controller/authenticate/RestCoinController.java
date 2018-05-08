package system.accounting.controller.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.accounting.domain.Coin;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.model.CoinRequestBody;
import system.accounting.service.CoinService;

import java.util.List;

/**
 * Created by KAI on 4/22/18.
 */
@RestController
@RequestMapping("/api/protected")
public class RestCoinController {

    @Autowired
    @Qualifier("coinMarketCapService")
    private CoinService coinService;

    @GetMapping(value = "/coins")
    public ResponseEntity getAllCoinsByUser() throws CoinNotFoundException {
       List<Coin> coins = coinService.getAllCoins();
       return ResponseEntity.ok(coins);
    }


    @PostMapping("/coins")
    public ResponseEntity saveAllCoinByUser(@RequestBody CoinRequestBody coinRequestBodys) throws CoinNotFoundException {
        List<Coin> coins = coinService.saveAllCoins(coinRequestBodys);
        return ResponseEntity.ok(coins);
    }

    @DeleteMapping("/coins/{id}")
    public ResponseEntity deleteCoins(@PathVariable String id) {
        coinService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
