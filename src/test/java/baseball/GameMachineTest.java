package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameMachineTest {
    private static GameMachine gameMachine;

    @BeforeEach
    void setUp() {
        gameMachine = new GameMachine();
    }

    @Test
    void 게임시작() {
        String input = "1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gameMachine.play();
    }

    @Test
    void 랜덤_넘버_세자리_생성() {
        Balls threeRandomNumbers = gameMachine.generateThreeRandomBalls();
    }

    @Test
    void 숫자를_입력받는다() {
        String input = "1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Balls playerInputBalls = gameMachine.getPlayerInput();
        assertThat(playerInputBalls).isInstanceOf(Balls.class);

        Balls tempBalls = new Balls();
        tempBalls.addBall(new Ball(1));
        tempBalls.addBall(new Ball(2));
        tempBalls.addBall(new Ball(3));

        assertThat(playerInputBalls).isEqualTo(tempBalls);
    }

    @Test
    void 예외테스트_문자를_입력받는다() {
        String input = "a b c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void 예외테스트_한자리_이상의_숫자를_입력받는다() {
        String input = "1 12 31";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한자리의 숫자만 올 수 있습니다.");
    }

    @Test
    void 단일_숫자_입력받는다() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            gameMachine.getPlayerInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 숫자를 띄어쓰기로 구분하여 입력해주세요.");
    }

    @Test
    void 입력받고_출력() {
        String input = "1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String s = Console.readLine();
        System.out.println(s);
        assertThat(s).isEqualTo("1 2 3");
    }
}