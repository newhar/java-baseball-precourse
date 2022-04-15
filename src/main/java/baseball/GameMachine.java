package baseball;

import camp.nextstep.edu.missionutils.Console;

public final class GameMachine {
    private final Computer computer;
    private final Player player;

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

    public Balls generateThreeRandomBalls() {
        Balls randomNumberBalls = new Balls();

        while (!randomNumberBalls.isMaximumSize()) {
            randomNumberBalls.addBall();
        }

        return randomNumberBalls;
    }

    public Balls getPlayerInput() {
        System.out.print(CommonMessage.GET_USER_INPUT);
        String playerInput = Console.readLine();

        return new Balls(playerInput.split(""));
    }

    private boolean guess() {
        player.initBalls(getPlayerInput());
        GameResult gameResult = computer.compareWithPlayerBall(player.getBalls());

        System.out.println(gameResult.getResultMessage());

        return gameResult.checkGameOver();
    }

    private boolean askReplay() {
        System.out.println(CommonMessage.GAME_OVER);
        System.out.print(CommonMessage.ASK_REPLAY);
        ReplayAnswer answer = new ReplayAnswer(Console.readLine());

        return answer.isReplay();
    }
}

