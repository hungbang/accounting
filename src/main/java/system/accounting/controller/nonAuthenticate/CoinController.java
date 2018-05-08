package system.accounting.controller.nonAuthenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;
import system.accounting.service.CoinService;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by KAI on 4/14/18.
 */
@RestController
@RequestMapping("/api/accountants")
public class CoinController {

    @Autowired
    @Qualifier("coinMarketCapService")
    private CoinService coinService;

    @GetMapping(value = "/coins/supported")
    public ResponseEntity supportedCoins() throws IOException, CoinsDataNotFoundException {
        return ResponseEntity.ok(coinService.getCoinsSupported());
    }


    @GetMapping("/coins/supported/{keyword}")
    public ResponseEntity supportedCoinsByKeyword(@PathVariable @NotNull String keyword) throws IOException, CoinsDataNotFoundException {
        CoinsDataMapper coinsDataMapper = coinService.findCoinsByKeyword(keyword);
        return ResponseEntity.ok(coinsDataMapper);
    }

    @GetMapping("/coins/supported/{keyword}/{amount}")
    public ResponseEntity supportedCoinsByKeyword(@PathVariable @NotNull String keyword, @PathVariable @NotNull BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        CoinsDataResponseWrapper coinsDataResponseWrapper = coinService.getPriceOfCoin(keyword, amount);
        return ResponseEntity.ok(coinsDataResponseWrapper);
    }



}
