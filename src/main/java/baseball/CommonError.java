package baseball;

public enum CommonError {
    UNDER_THAN_MAXIMUM_EA_BALLS_ERROR("세 개의 숫자를 띄어쓰기로 구분하여 입력해주세요."),
    OUT_OF_BOUNDS_LENGTH_ERROR("지정된 길이를 벗어난 입력입니다."),
    OUT_OF_RANGE_ERROR("지정된 범위를 벗어난 입력입니다."),
    NOT_NUMBER_ERROR("숫자만 입력할 수 있습니다.");

    private final String message;

    CommonError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
