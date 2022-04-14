package baseball;

public enum CommonMessage {
    OUT_OF_BOUNDS_LENGTH_ERROR("지정된 길이를 벗어난 입력입니다."),
    NOT_NUMBER_ERROR("숫자만 입력할 수 있습니다."),
    GET_USER_INPUT("숫자를 입력해주세요 : "),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_REPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
