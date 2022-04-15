package baseball;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {
    @Test
    void 공갯수_한도범위_테스트_softly() {
        SoftAssertions softly = new SoftAssertions();

        Balls balls = new Balls();
        balls.addBall(new Ball(3));
        balls.addBall(new Ball(4));
        softly.assertThat(balls.isMaximumSize()).isEqualTo(false);
        balls.addBall(new Ball(5));
        softly.assertThat(balls.isMaximumSize()).isEqualTo(true);
        balls.addBall(new Ball(6));
        softly.assertThat(balls.isMaximumSize()).isEqualTo(true);

        softly.assertAll();
    }

    @Test
    void 공갯수_한도범위_테스트_without_softly() {
        Balls balls = new Balls();
        balls.addBall(new Ball(3));
        balls.addBall(new Ball(4));
        assertThat(balls.isMaximumSize()).isEqualTo(false);
        balls.addBall(new Ball(5));
        assertThat(balls.isMaximumSize()).isEqualTo(true);
        balls.addBall(new Ball(6));
        assertThat(balls.isMaximumSize()).isEqualTo(true);
    }

    @Test
    void 이미_중복된_볼_있는지_테스트() {
        Balls balls = new Balls();
        balls.addBall(new Ball(3));
        assertThat(balls.hasContainBall(new Ball(4))).isEqualTo(false);
        assertThat(balls.hasContainBall(new Ball(3))).isEqualTo(true);
    }
}