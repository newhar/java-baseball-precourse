package baseball;

public enum ResultStatus {
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱");

    private final String message;

    ResultStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
