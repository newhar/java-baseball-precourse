package baseball;

import java.util.Objects;

public class Ball {
    int ballNumber;

    public Ball(int pickNumberInRange) {
        this.ballNumber = pickNumberInRange;
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
