package kr.co.shorturl.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import kr.co.shorturl.domain.URL;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class URLDto {
    private String key;
    @NotBlank
    @Pattern(regexp = "[(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")
    private String origin;
    private Long count;

    public URL toEntity() {
        return URL.builder()
                .key(key)
                .origin(origin)
                .count(count)
                .build();
    }
}
