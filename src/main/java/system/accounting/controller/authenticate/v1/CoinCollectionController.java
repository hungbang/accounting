package system.accounting.controller.authenticate.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.accounting.model.CoinRequestBody;

/**
 * Created by KAI on 5/13/18.
 */
@RestController
@RequestMapping("/api/protected/v1")
public class CoinCollectionController {

    @PostMapping("/coins")
    public ResponseEntity saveCoins(@RequestBody CoinRequestBody coinRequestBodys){

        return ResponseEntity.noContent().build();

    }

}
