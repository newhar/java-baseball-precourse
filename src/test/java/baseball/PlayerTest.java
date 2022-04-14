package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {


    private static Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 입력받은_공_셋팅() {
        Balls balls = new Balls(new String[] {"4","7","9"});
        player.initBalls(balls);

        assertThat(player.getBalls()).isEqualTo(balls);
    }


}