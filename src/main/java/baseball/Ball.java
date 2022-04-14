package baseball;

import java.util.Objects;

public class Ball {
    private static final int BALL_INDEX = 0;
    private static final int MAXIMUM_BALL_DIGIT = 1;

    public int ballNumber;

    public Ball(int num) {
        this.ballNumber = num;
    }

    public Ball(String num) {
        if (num.length() > MAXIMUM_BALL_DIGIT) {
            throw new IllegalArgumentException(CommonError.OUT_OF_BOUNDS_LENGTH_ERROR.getMessage());
        }

        if (!Character.isDigit(num.charAt(BALL_INDEX))) {
            throw new IllegalArgumentException(CommonError.NOT_NUMBER_ERROR.getMessage());
        }

        this.ballNumber = Integer.parseInt(num);
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
