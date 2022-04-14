package baseball;

public class Player {
    Balls balls;

    public void initBalls(Balls balls) {
        this.balls = balls;
    }

    public Balls getBalls() {
        return this.balls;
    }
}
