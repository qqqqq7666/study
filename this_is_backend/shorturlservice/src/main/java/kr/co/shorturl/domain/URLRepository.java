package kr.co.shorturl.domain;

import java.util.List;

public interface URLRepository {
    URL createURL(URL url);
    List<URL> findAll();
    URL findByKey(String key);
}
