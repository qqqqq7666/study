package kr.co.shorturl.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import kr.co.shorturl.presentation.URLDto;
import lombok.Builder;

@Builder
public class URL {
    @Size(min = 8, max = 8)
    private String key;
    private String origin;
    @Min(0)
    private Long count;

    public URLDto toDto() {
        return URLDto.builder()
                .key(key)
                .origin(origin)
                .count(count)
                .build();
    }

    public Boolean redirect(String key) {
        if (this.key.equals(key))
            count++;
        return this.key.equals(key);
    }
}
