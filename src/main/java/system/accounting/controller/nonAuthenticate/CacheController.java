package system.accounting.controller.nonAuthenticate;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.accounting.config.CacheConfig;

@Controller
@RequestMapping("/")
public class CacheController {

    @CacheEvict(value = CacheConfig.CACHE_ONE, allEntries = true)
    @RequestMapping(value = "/clearCache", method = RequestMethod.GET)
    public ResponseEntity<String> clearCache() {
        return new ResponseEntity<String>("Cache Cleared", HttpStatus.OK);
    }
}