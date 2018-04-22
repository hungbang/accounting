package system.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.service.CoinService;

import java.io.IOException;
import java.util.Set;

/**
 * Created by KAI on 4/18/18.
 */

@RestController
@RequestMapping("/api/accountants")
public class CryptoCompareController {


    @Autowired
    @Qualifier("coinCompareService")
    private CoinService coinCompareService;

    @GetMapping("/data/coinlist/")
    public ResponseEntity coinList() throws CoinsDataNotFoundException, IOException {
        Set<String> coinIds = coinCompareService.getCoinsSupported();
        return ResponseEntity.ok(coinIds);
    }



}
