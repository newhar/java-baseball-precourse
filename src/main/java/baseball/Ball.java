package baseball;

import java.util.Objects;

public final class Ball {
    private static final int BALL_INDEX = 0;
    private static final int MINIMUM_RANGE_OF_NUM = 1;
    private static final int MAXIMUM_RANGE_OF_NUM = 9;

    private final int ballNumber;

    public Ball(int num) {
        this.ballNumber = num;
    }

    public Ball(String num) {
        validateBallNumber(num);

        this.ballNumber = Integer.parseInt(num);
    }

    private void validateBallNumber(String num) {
        if (!Character.isDigit(num.charAt(BALL_INDEX))) {
            throw new IllegalArgumentException(CommonMessage.NOT_NUMBER_ERROR);
        }

        int parsedNum = Integer.parseInt(num);
        if (parsedNum < MINIMUM_RANGE_OF_NUM || parsedNum > MAXIMUM_RANGE_OF_NUM ) {
            throw new IllegalArgumentException(CommonMessage.OUT_OF_RANGE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

}
