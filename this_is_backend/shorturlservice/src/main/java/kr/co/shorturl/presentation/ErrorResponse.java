package kr.co.shorturl.presentation;

public class ErrorResponse {
    private Integer status;
    private String errorDescription;
    private String errorCode;

    public ErrorResponse(ErrorCode errorCode) {
        status = errorCode.getHttpStatus().value();
        errorDescription = errorCode.getErrorMessage();
        this.errorCode = errorCode.name();
    }
}
