package baseball;

public class Computer {
    Balls balls;

    public void initRandomBalls(Balls generateThreeRandomNumbers) {
        this.balls = generateThreeRandomNumbers;
    }

    public void initBalls(Balls balls) {
        this.balls = balls;
    }

    public int getSameBallCountWith(Balls playerBalls) {
        int sameBallCnt = 0;

        for (Ball playerBall : playerBalls.getBalls()) {
            sameBallCnt += checkSameBall(playerBall);
        }

        return sameBallCnt;
    }

    private int checkSameBall(Ball ball) {
        if( this.balls.hasContainBall(ball) ) {
            return 1;
        }
        return 0;
    }


}
