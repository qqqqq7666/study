package kr.co.shorturl.application;

import kr.co.shorturl.domain.URL;
import kr.co.shorturl.infrastructure.ListURLRepository;
import kr.co.shorturl.presentation.URLDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class URLServiceUnitTest {
    private static final Logger log = LoggerFactory.getLogger(URLServiceUnitTest.class);
    @Mock
    ListURLRepository listUrlRepository;
    @InjectMocks
    URLService urlService;

    @Test
    void createTest() {
        String origin = "www.naver.com";
        URL url = URL.builder()
                .key("123")
                .origin("www.naver.com")
                .count(0L)
                .build();

        when(listUrlRepository.createURL(url))
                .thenReturn(url);

        assertEquals(urlService.createURL(origin).getKey(), url.toDto().getKey());
    }

//    @Test
//    void retrieve() {
//        URL url = URL.builder()
//                .key("123")
//                .origin("www.naver.com")
//                .count(0L)
//                .build();
//        List<URL> urls = new CopyOnWriteArrayList<>();
//        urls.add(url);
//
//        when(urlRepository.retrieveURL())
//                .thenReturn(urls);
//
//        log.info(urls.toString());
//    }

    @Test
    void redirectTest() {
        String key = "123";
        URL url = URL.builder()
                .key("123")
                .origin("www.qqq.com")
                .count(0L)
                .build();
        when(listUrlRepository.findByKey(key))
                .thenReturn(url);

        URLDto urlDto = urlService.redirectURL("123");
    }
}
