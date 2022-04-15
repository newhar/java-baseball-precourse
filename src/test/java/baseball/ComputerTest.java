package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {
    private static Computer computer;
    private static Player player;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        player = new Player();
    }

    @Test
    void 동일한_야구공_숫자_갯수_확인_테스트() throws Exception {
        Balls balls = new Balls(new String[] {"1", "2", "3"});
        computer.initBalls(balls);

        Balls playerBalls = new Balls(new String[] {"4", "3", "1"});
        player.initBalls(playerBalls);

        Method method = computer.getClass().getDeclaredMethod("getSameBallCountWith", Balls.class);
        method.setAccessible(true);

        int sameBallCnt = (int)method.invoke(computer, player.getBalls());
        assertThat(sameBallCnt).isEqualTo(2);
    }

    @Test
    void 스트라이크_갯수_확인_테스트() throws Exception {
        Balls balls = new Balls(new String[] {"1", "2", "3"});
        computer.initBalls(balls);

        Balls playerBalls = new Balls(new String[] {"4", "2", "1"});
        player.initBalls(playerBalls);

        Method method = computer.getClass().getDeclaredMethod("getStrikeCountWith", Balls.class);
        method.setAccessible(true);

        int strikeCnt = (int)method.invoke(computer, player.getBalls());

        assertThat(strikeCnt).isEqualTo(1);
    }


    @Test
    void 컴퓨터_플레이어_볼비교_테스트() {
        Balls balls = new Balls(new String[] {"7", "8", "1"});
        computer.initBalls(balls);

        Balls playerBalls = new Balls(new String[] {"1", "8", "7"});
        player.initBalls(playerBalls);

        assertThat(computer.compareWithPlayerBall(player.getBalls()).getResultMessage()).isEqualTo("2볼 1스트라이크");
    }

}