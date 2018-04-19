package system.accounting.controller;

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
import system.accounting.service.SupportedCoinService;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by KAI on 4/14/18.
 */
@RestController
@RequestMapping("/accountants")
public class AccountController {

    @Autowired
    @Qualifier("coinMarketCapService")
    private SupportedCoinService supportedCoinService;

    @GetMapping("/coins/supported")
    public ResponseEntity supportedCoins() throws IOException {
        return ResponseEntity.ok(supportedCoinService.getCoinsSupported());
    }


    @GetMapping("/coins/supported/{keyword}")
    public ResponseEntity supportedCoinsByKeyword(@PathVariable @NotNull String keyword) throws IOException, CoinsDataNotFoundException {
        CoinsDataMapper coinsDataMapper = supportedCoinService.findCoinsByKeyword(keyword);
        return ResponseEntity.ok(coinsDataMapper);
    }

    @GetMapping("/coins/supported/{keyword}/{amount}")
    public ResponseEntity supportedCoinsByKeyword(@PathVariable @NotNull String keyword, @PathVariable @NotNull BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        CoinsDataResponseWrapper coinsDataResponseWrapper = supportedCoinService.getPriceOfCoin(keyword, amount);
        return ResponseEntity.ok(coinsDataResponseWrapper);
    }

}
