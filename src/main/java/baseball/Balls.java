package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private static final int MAX_LEN_OF_BALLS = 3;
    private static final int MIN_RANGE_OF_BALL = 1;
    private static final int MAX_RANGE_OF_BALL = 9;

    List<Ball> balls = new ArrayList<>();

    public Balls() {}

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public Balls(String[] balls) {

        for(String s : balls) {
            this.balls.add(new Ball(s));
        }
    }

    public boolean isMaximumSize() {
        return balls.size() >= MAX_LEN_OF_BALLS;
    }

    public boolean hasContainBall(Ball randomNumberBall) {
        return balls.contains(randomNumberBall);
    }

    public void addBall() {
        boolean containBallFlag = true;
        Ball ball = null;

        while(containBallFlag) {
            ball = new Ball(Randoms.pickNumberInRange(MIN_RANGE_OF_BALL,MAX_RANGE_OF_BALL));
            containBallFlag = hasContainBall(ball);
        }

        balls.add(ball);
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
