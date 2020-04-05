package life.max.community.exception;

public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(CustomizeErrorCodeInt errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

}