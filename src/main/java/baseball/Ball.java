package baseball;

import java.util.Objects;

public class Ball {
    private static final int BALL_INDEX = 0;
    private static final int MAXIMUM_BALL_NUMBER_RANGE = 1;

    int ballNumber;

    public Ball(int num) {
        this.ballNumber = num;
    }

    public Ball(String num) {
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
