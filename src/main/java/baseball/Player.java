package baseball;

public final class Player {
    private Balls balls;

    public void initBalls(Balls balls) {
        this.balls = balls;
    }

    public Balls getBalls() {
        return this.balls;
    }
}
