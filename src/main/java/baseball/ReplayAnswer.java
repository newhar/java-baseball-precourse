package baseball;

public class ReplayAnswer {

    private static final int ANSWER_LENGTH = 1;
    int answer;

    public ReplayAnswer(String answer) {
        if (answer.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException(CommonError.OUT_OF_BOUNDS_LENGTH_ERROR.getMessage());
        }

        if (!Character.isDigit(answer.charAt(0))) {
            throw new IllegalArgumentException(CommonError.NOT_NUMBER_ERROR.getMessage());
        }

        this.answer = Integer.parseInt(answer);
    }

    public boolean isReplay() {
        return answer == 1;
    }
}