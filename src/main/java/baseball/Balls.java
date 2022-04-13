package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int MAX_LEN_OF_BALLS = 3;
    private static final int MIN_RANGE_OF_BALL = 1;
    private static final int MAX_RANGE_OF_BALL = 9;

    List<Ball> balls = new ArrayList<>();

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

}
