package system.accounting.config;

import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

    public final static String CACHE_ONE = "cacheOne";
    public final static String CACHE_TWO = "cacheTwo";

    private final Logger log = LoggerFactory
            .getLogger(CacheConfig.class);

    @Bean
    @Override
    public CacheManager cacheManager() {
        log.info("Initializing simple Guava Cache manager.");
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        GuavaCache cache1 = new GuavaCache(CACHE_ONE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .build());

        GuavaCache cache2 = new GuavaCache(CACHE_TWO, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());

        cacheManager.setCaches(Arrays.asList(cache1,cache2));

        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}