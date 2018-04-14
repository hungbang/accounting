package system.accounting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.ErrorResponseWrapper;

/**
 * Created by KAI on 4/14/18.
 */
@ControllerAdvice
public class RestExceptionHandling {

    public final static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandling.class);

    @ExceptionHandler(CoinsDataNotFoundException.class)
    public ResponseEntity handlingCoinsDataNotFoundException(CoinsDataNotFoundException e){
        LOGGER.error("CoinsData is not found : "+ e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseWrapper("CoinsData is not found.", "CoinsData is not found."));
    }


}
