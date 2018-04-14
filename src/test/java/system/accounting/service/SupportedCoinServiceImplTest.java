//package system.accounting.service;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import system.accounting.DemoApplication;
//import system.accounting.model.CoinsDataMapper;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@PropertySource("classpath:application.properties")
//@ContextConfiguration(classes = DemoApplication.class)
//@TestPropertySource(properties = {"classpath:application.properties"})
//public class SupportedCoinServiceImplTest {
//
//    public static final Logger LOGGER = LoggerFactory.getLogger(SupportedCoinServiceImplTest.class);
//
//    @InjectMocks
//    private SupportedCoinServiceImpl supportedCoinService;
//
//    @Test
//    public void getCoinsSupported() throws Exception {
//        List<CoinsDataMapper> coins =  supportedCoinService.getCoinsSupported();
//        Assert.assertNotNull(coins);
//        Assert.assertEquals(100, coins.size());
//    }
//
//}