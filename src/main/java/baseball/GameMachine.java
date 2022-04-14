package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameMachine {
    Computer computer;
    Player player;

    public GameMachine() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public boolean play() {
        boolean gameOverFlag = false;
        this.computer.initRandomBalls(generateThreeRandomBalls());

        while(!gameOverFlag) {
            this.player.initBalls(getPlayerInput());
            String gameResult = this.computer.compareWithPlayerBall(this.player.getBalls());
            System.out.println(gameResult);

            gameOverFlag = checkGameOver(gameResult);
        }

        return askReplay();
    }

    private boolean askReplay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        ReplayAnswer answer = new ReplayAnswer(Console.readLine());

        if(answer.isReplay()) {
          return true;
        }

        return false;
    }

    private boolean checkGameOver(String gameResult) {
        return gameResult.equals("3스트라이크");
    }


    public Balls generateThreeRandomBalls() {
        Balls randomNumberBalls = new Balls();

        while (!randomNumberBalls.isMaximumSize()) {
           randomNumberBalls.addBall();
        }

        return randomNumberBalls;
    }

    public Balls getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        return new Balls(playerInput.split(""));
    }
}

