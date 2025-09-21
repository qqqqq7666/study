package kr.co.shorturl.domain;

public class LackOfShortURLKeyException extends RuntimeException {
    public LackOfShortURLKeyException(String message) {
        super(message);
    }
}
