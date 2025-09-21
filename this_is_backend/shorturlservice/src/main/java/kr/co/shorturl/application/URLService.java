package kr.co.shorturl.application;

import kr.co.shorturl.domain.URL;
import kr.co.shorturl.infrastructure.ListURLRepository;
import kr.co.shorturl.presentation.URLDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class URLService {
    private final ListURLRepository listUrlRepository;

    public URLDto createURL(String origin) {
        String key = UUID.randomUUID().toString()
                .substring(0, 7);
        URL url = URL.builder()
                .key(key)
                .origin(origin)
                .count(0L)
                .build();
        return listUrlRepository.createURL(url).toDto();
    }

    public String getOriginByKey(String key) {
        return listUrlRepository.findByKey(key).toDto().getOrigin();
    }

    public List<URLDto> retrieveAllUrl() {
        return listUrlRepository.findAll().stream()
                .map(URL::toDto)
                .toList();
    }
}
