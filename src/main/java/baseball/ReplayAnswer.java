package baseball;

public final class ReplayAnswer {
    private static final int ANSWER_LENGTH = 1;
    private static final int MINIMUM_RANGE_OF_ANSWER = 1;
    private static final int MAXIMUM_RANGE_OF_ANSWER = 2;
    private static final int FIRST_IDX = 0;
    private static final int REPLAY = 1;

    private final int answer;

    public ReplayAnswer(String answer) {
        validateAnswer(answer);

        this.answer = Integer.parseInt(answer);;
    }

    public boolean isReplay() {
        return answer == REPLAY;
    }

    private void validateAnswer(String answer) {
        validate(answer.length() != ANSWER_LENGTH, CommonMessage.OUT_OF_BOUNDS_LENGTH_ERROR);
        validate(!Character.isDigit(answer.charAt(FIRST_IDX)), CommonMessage.NOT_NUMBER_ERROR);
        validate(Integer.parseInt(answer) < MINIMUM_RANGE_OF_ANSWER, CommonMessage.OUT_OF_RANGE_ERROR);
        validate(Integer.parseInt(answer) > MAXIMUM_RANGE_OF_ANSWER, CommonMessage.OUT_OF_RANGE_ERROR);
    }

    private void validate(boolean b, String ErrorMessage) {
        if (b) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }


}
