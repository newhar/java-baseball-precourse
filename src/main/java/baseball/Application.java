package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMachine gameMachine = new GameMachine();

        boolean gameContinueFlag = true;

        while(gameContinueFlag) {
            gameContinueFlag = gameMachine.play();
        }
    }
}
