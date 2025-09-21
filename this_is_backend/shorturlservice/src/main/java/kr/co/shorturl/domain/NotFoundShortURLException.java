package kr.co.shorturl.domain;

public class NotFoundShortURLException extends RuntimeException {
    public NotFoundShortURLException(String message) {
        super(message);
    }
}
