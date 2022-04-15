package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class GameMachineTest {
    private static GameMachine gameMachine;

    @BeforeEach
    void setUp() {
        gameMachine = new GameMachine();
    }

    @Test
    void 랜덤_넘버_세자리_생성() {
        Balls threeRandomNumbers = gameMachine.generateThreeRandomBalls();

        assertThat(threeRandomNumbers).isInstanceOf(Balls.class);
    }

    @Test
    void 숫자를_입력받는다() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Balls playerInputBalls = gameMachine.getPlayerInput();
        Balls tempBalls = new Balls();
        tempBalls.addBall(new Ball(1));
        tempBalls.addBall(new Ball(2));
        tempBalls.addBall(new Ball(3));

        assertThat(playerInputBalls).isInstanceOf(Balls.class).isEqualTo(tempBalls);
    }

    @Test
    void 예외테스트_문자를_입력받는다() {
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void 예외테스트_세자리_이상의_숫자를_입력받는다() {
        String input = "11231";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지정된 길이를 벗어난 입력입니다.");
    }

    @Test
    void 단일_숫자_입력받는다() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지정된 길이를 벗어난 입력입니다.");
    }

    @Test
    void InputStream_setIn_연습() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String s = Console.readLine();
        assertThat(s).isEqualTo("123");
    }
}