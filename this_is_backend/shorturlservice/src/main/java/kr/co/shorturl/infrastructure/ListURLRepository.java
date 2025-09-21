package kr.co.shorturl.infrastructure;

import kr.co.shorturl.domain.NotFoundShortURLException;
import kr.co.shorturl.domain.URL;
import kr.co.shorturl.domain.URLRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ListURLRepository implements URLRepository {
    private final List<URL> urls = new CopyOnWriteArrayList<>();

    @Override
    public URL createURL(URL url) {
        urls.add(url);
        return url;
    }

    @Override
    public List<URL> findAll() {
        return urls;
    }
    @Override
    public URL findByKey(String key) {
        log.info("key : {}", key);

        return urls.stream()
                .filter(url -> url.redirect(key))
                .findFirst()
                .orElseThrow(() -> new NotFoundShortURLException("Key가 존재하지 않음"));
    }
}
