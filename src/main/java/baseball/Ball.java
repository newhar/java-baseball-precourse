package baseball;

import java.util.Objects;

public class Ball {
    private static final int BALL_INDEX = 0;

    private int ballNumber;

    public Ball(int num) {
        this.ballNumber = num;
    }

    public Ball(String num) {
        if (!Character.isDigit(num.charAt(BALL_INDEX))) {
            throw new IllegalArgumentException(CommonMessage.NOT_NUMBER_ERROR.getMessage());
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
