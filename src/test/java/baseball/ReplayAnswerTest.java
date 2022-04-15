package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReplayAnswerTest {

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,false"})
    void isReplay(String answer, boolean expected) {
        ReplayAnswer replayAnswer = new ReplayAnswer(answer);

        assertThat(replayAnswer.isReplay()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,지정된 범위의 숫자가 아닙니다.","41,지정된 길이를 벗어난 입력입니다.","a,숫자만 입력할 수 있습니다."})
    void 예외테스트_다른숫자나_문자_입력(final String userInput, String msg) {
        assertThatThrownBy(() -> {
            ReplayAnswer replayAnswer = new ReplayAnswer(userInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(msg);
    }
}