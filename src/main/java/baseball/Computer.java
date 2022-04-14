package baseball;

public class Computer {
    private static final int SAME = 1;
    private static final int NOT_SAME = 0;

    private Balls balls;

    public void initRandomBalls(Balls generateThreeRandomBalls) {
        this.balls = generateThreeRandomBalls;
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
            return SAME;
        }

        return NOT_SAME;
    }


    public int getStrikeCountWith(Balls playerBalls) {
        int strikeCnt = 0;
        int ballIdx = 0;

        for(Ball playerBall : playerBalls.getBalls()) {
            strikeCnt += checkStrikeAtWith(ballIdx, playerBall);
            ballIdx += 1;
        }

        return strikeCnt;
    }

    private int checkStrikeAtWith(int ballIdx, Ball playerBall) {
        if(playerBall.equals(this.balls.getBallAt(ballIdx))) {
            return SAME;
        }

        return NOT_SAME;
    }

    public GameResult compareWithPlayerBall(Balls playerBall) {
        int sameBallCount = getSameBallCountWith(playerBall);
        int strikeCount = getStrikeCountWith(playerBall);
        int ballCount = sameBallCount - strikeCount;

        return new GameResult(strikeCount, ballCount);
    }

}
