package life.max.community.exception;

public enum CustomizeErrorCode implements CustomizeErrorCodeInt {
    QUESTION_NOT_FOUND("问题找不到，换一个试试");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
