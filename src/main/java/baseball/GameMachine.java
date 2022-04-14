package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameMachine {
    private Computer computer;
    private Player player;

    public GameMachine() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public boolean play() {
        boolean gameOverFlag = false;
        computer.initRandomBalls(generateThreeRandomBalls());

        while(!gameOverFlag) {
            gameOverFlag = guess();
        }

        return askReplay();
    }

    private boolean guess() {
        player.initBalls(getPlayerInput());
        GameResult gameResult = computer.compareWithPlayerBall(player.getBalls());

        System.out.println(gameResult.getResultMessage());

        return gameResult.checkGameOver();
    }

    public Balls generateThreeRandomBalls() {
        Balls randomNumberBalls = new Balls();

        while (!randomNumberBalls.isMaximumSize()) {
            randomNumberBalls.addBall();
        }

        return randomNumberBalls;
    }

    public Balls getPlayerInput() {
        System.out.print(CommonMessage.GET_USER_INPUT.getMessage());
        String playerInput = Console.readLine();

        return new Balls(playerInput.split(""));
    }

    private boolean askReplay() {
        System.out.println(CommonMessage.GAME_OVER.getMessage());
        System.out.print(CommonMessage.ASK_REPLAY.getMessage());
        ReplayAnswer answer = new ReplayAnswer(Console.readLine());

        if(answer.isReplay()) {
          return true;
        }

        return false;
    }
}

