package baseball;

public enum CommonError {
    UNDER_THAN_MAXIMUM_EA_BALLS_ERROR("세 개의 숫자를 띄어쓰기로 구분하여 입력해주세요."),
    OVER_MAXIMUM_BALL_DIGIT_ERROR("한자리의 숫자만 올 수 있습니다."),
    NOT_NUMBER_ERROR("숫자만 입력할 수 있습니다.");

    private final String message;

    CommonError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
