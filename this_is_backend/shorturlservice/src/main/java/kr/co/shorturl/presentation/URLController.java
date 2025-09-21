package kr.co.shorturl.presentation;

import kr.co.shorturl.application.URLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shorturl")
public class URLController {
    private final URLService urlService;

    @PostMapping
    public ResponseEntity<URLDto> createURL(@RequestBody String origin) {
        return ResponseEntity
                .created(URI.create("/shorturl"))
                .body(urlService.createURL(origin));
    }

    @GetMapping
    public ResponseEntity<List<URLDto>> retrieveURL() {
        return ResponseEntity.ok(urlService.retrieveAllUrl());
    }

    @GetMapping("/{key}")
    public ResponseEntity<?> redirectURL(@PathVariable String key) {
        String origin = urlService.getOriginByKey(key);
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .location(URI.create("https://" + origin))
                .build();
    }
}
