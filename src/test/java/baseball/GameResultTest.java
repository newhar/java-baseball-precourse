package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameResultTest {

    @Test
    void 결과_메세지_테스트() {
        GameResult gameResult = new GameResult(2, 1);
        GameResult gameResult2 = new GameResult(3, 0);
        GameResult gameResult3 = new GameResult(0, 0);

        assertThat(gameResult.getResultMessage()).isEqualTo("1볼 2스트라이크");
        assertThat(gameResult2.getResultMessage()).isEqualTo("3스트라이크");
        assertThat(gameResult3.getResultMessage()).isEqualTo("낫싱");
    }

    @Test
    void 게임_종료_확인_테스트() {
        GameResult gameOverResult = new GameResult(3, 0);
        GameResult gameNotOverResult = new GameResult(1,1);
        assertThat(gameNotOverResult.checkGameOver()).isEqualTo(false);
        assertThat(gameOverResult.checkGameOver()).isEqualTo(true);
    }

}