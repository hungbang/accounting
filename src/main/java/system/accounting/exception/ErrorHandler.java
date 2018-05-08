package system.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by KAI on 4/22/18.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity handlingCoinNotFoundException(CoinNotFoundException e) {
        return ResponseEntity.noContent().build();
    }

}
