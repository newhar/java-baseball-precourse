package baseball;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {"2,1,1볼 2스트라이크","3,0,3스트라이크","0,0,낫싱"})
    void 결과_메세지_테스트(int strikeCnt, int ballCnt, String expected) {

        GameResult gameResult = new GameResult(strikeCnt, ballCnt);

        assertThat(gameResult.getResultMessage()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,true","1,1,false"})
    void 게임_종료_확인_테스트(int strikeCnt, int ballCnt, boolean expected) {

        GameResult gameResult = new GameResult(strikeCnt, ballCnt);
        assertThat(gameResult.checkGameOver()).isEqualTo(expected);
    }

}