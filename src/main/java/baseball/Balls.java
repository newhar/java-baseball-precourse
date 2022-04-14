package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private static final int LENGTH_OF_BALLS = 3;
    private static final int MIN_RANGE_OF_BALL = 1;
    private static final int MAX_RANGE_OF_BALL = 9;

    private List<Ball> balls = new ArrayList<>();

    public Balls() {}

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public Balls(String[] balls) {
        if(balls.length != LENGTH_OF_BALLS ) {
            throw new IllegalArgumentException(CommonError.OUT_OF_BOUNDS_LENGTH_ERROR.getMessage());
        }

        for(String s : balls) {
            this.balls.add(new Ball(s));
        }
    }

    public boolean isMaximumSize() {
        return balls.size() >= LENGTH_OF_BALLS;
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

        System.out.println(ball.ballNumber);
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

    public List<Ball> getBalls() {
        return this.balls;
    }

    public Ball getBallAt(int ballIdx) {
        return this.balls.get(ballIdx);
    }
}
