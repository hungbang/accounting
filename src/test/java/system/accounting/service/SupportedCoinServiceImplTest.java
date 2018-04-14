package system.accounting.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import system.accounting.model.CoinsDataMapper;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SupportedCoinServiceImplTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SupportedCoinServiceImplTest.class);

    @InjectMocks
    private SupportedCoinServiceImpl supportedCoinService;

    @Test
    public void getCoinsSupported() throws Exception {
        List<CoinsDataMapper> coins =  supportedCoinService.getCoinsSupported();
        Assert.assertNotNull(coins);
        Assert.assertEquals(100, coins.size());
    }

}