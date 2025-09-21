package kr.co.shorturl.presentation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    S001(HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
    S002(HttpStatus.INTERNAL_SERVER_ERROR, "단축 URL 자원이 부족합니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;
}
