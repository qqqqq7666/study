package kr.co.shorturl.presentation;

import kr.co.shorturl.domain.LackOfShortURLKeyException;
import kr.co.shorturl.domain.NotFoundShortURLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundShortURLException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundShortURLException(NotFoundShortURLException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ErrorCode.S001));
    }

    @ExceptionHandler(LackOfShortURLKeyException.class)
    public ResponseEntity<ErrorResponse> handleLackOfShortURLKeyException() {
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(ErrorCode.S002));
    }
}
