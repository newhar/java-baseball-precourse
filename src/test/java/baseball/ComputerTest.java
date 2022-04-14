package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private static Computer computer;
    private static Player player;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        player = new Player();
    }

    @Test
    void 동일한_야구공_숫자_갯수_확인_테스트() {
        Balls balls = new Balls(new String[] {"1", "2", "3"});
        computer.initBalls(balls);

        Balls playerBalls = new Balls(new String[] {"4", "3", "1"});
        player.initBalls(playerBalls);

        int sameBallCnt = computer.getSameBallCountWith(player.getBalls());
        assertThat(sameBallCnt).isEqualTo(2);
    }

    @Test
    void 스트라이크_갯수_확인_테스트() {
        Balls balls = new Balls(new String[] {"1", "2", "3"});
        computer.initBalls(balls);

        Balls playerBalls = new Balls(new String[] {"4", "2", "1"});
        player.initBalls(playerBalls);

        int strikeCnt = computer.getStrikeCountWith(player.getBalls());
        assertThat(strikeCnt).isEqualTo(1);
    }
}