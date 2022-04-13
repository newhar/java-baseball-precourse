package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMachine {
    public void play() {
    }

    public Balls generateThreeRandomNumbers() {
        Balls randomNumberBalls = new Balls();

        while (!randomNumberBalls.isMaximumSize()) {
           randomNumberBalls.addBall();
        }

        return randomNumberBalls;
    }

}

