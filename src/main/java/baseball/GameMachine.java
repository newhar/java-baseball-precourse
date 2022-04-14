package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMachine {
    Computer computer;
    Player player;

    public GameMachine() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void play() {
        boolean continueGameFlag = true;
        this.computer.initRandomBalls(generateThreeRandomBalls());
        this.player.initBalls(getPlayerInput());
    }


    public Balls generateThreeRandomBalls() {
        Balls randomNumberBalls = new Balls();

        while (!randomNumberBalls.isMaximumSize()) {
           randomNumberBalls.addBall();
        }

        return randomNumberBalls;
    }

    public Balls getPlayerInput() {
        String playerInput = Console.readLine();
        String[] splitedInput = playerInput.split(" ");

        Balls playerInputBalls = new Balls(splitedInput);

        return playerInputBalls;
    }
}

