//package system.accounting.controller.wss;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.simp.stomp.StompFrameHandler;
//import org.springframework.messaging.simp.stomp.StompHeaders;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//import org.springframework.web.socket.sockjs.client.SockJsClient;
//import org.springframework.web.socket.sockjs.client.Transport;
//import org.springframework.web.socket.sockjs.client.WebSocketTransport;
//
//import java.lang.reflect.Type;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeoutException;
//
//import static java.util.concurrent.TimeUnit.SECONDS;
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CoinWssControllerTest {
//
//
//    @Value("${local.server.port}")
//    private int port;
//    private String URL;
//
//    private static final String SEND_TO__ENDPOINT = "/hello";
//    private static final String SUBSCRIBE_HELLO_ENDPOINT = "/topic/greetings";
//
//    private CompletableFuture<String> completableFuture;
//
//    @Before
//    public void setup() {
//        completableFuture = new CompletableFuture<>();
//        URL = "ws://localhost:" + port + "/coins";
//    }
//
//
//    @Test
//    public void testCreateGameEndpoint() throws URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
//        String uuid = UUID.randomUUID().toString();
//        System.out.println("====port====port====="+port);
//        WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(createTransportClient()));
//        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//
//        StompSession stompSession = stompClient.connect(URL, new StompSessionHandlerAdapter() {
//        }).get(1, SECONDS);
//
//        stompSession.subscribe(SUBSCRIBE_HELLO_ENDPOINT , new CreateTestStompFrameHandler());
//        stompSession.send(SEND_TO__ENDPOINT , uuid);
//
//        String gameState = completableFuture.get(30, SECONDS);
//
//        assertNotNull(gameState);
//    }
//
//
//
//    private List<Transport> createTransportClient() {
//        List<Transport> transports = new ArrayList<>(1);
//        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//        return transports;
//    }
//
//    private class CreateTestStompFrameHandler implements StompFrameHandler {
//        @Override
//        public Type getPayloadType(StompHeaders stompHeaders) {
//            return String.class;
//        }
//
//        @Override
//        public void handleFrame(StompHeaders stompHeaders, Object o) {
//            completableFuture.complete((String) o);
//        }
//    }
//
//
//}