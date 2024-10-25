package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator cal;

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "2 - 3", "2 * 3", "2 / 3" , "2 + 3 / 4 * 2"})
    void splitInputStringTest(String input) {
        cal = new StringCalculator(input);

        Queue<String> result = cal.getInput();
        assertThat(result).contains(input.split(" "));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 + ", "2 3"})
    void splitInputWrongExpressionTest(String input) {
        assertThatThrownBy(() -> new StringCalculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ** 3", "2 % 3", "2 ^ 3", "2 & 3"})
    void splitInputWrongOperatorTest(String input) {
        cal = new StringCalculator(input);
        assertThatThrownBy(() -> cal.calculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 연산자는 존재하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + a", "2.5 + 1.5"})
    void checkAndGetIntTest(String input) {
        cal = new StringCalculator(input);
        assertThatThrownBy(() -> cal.calculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력해 주세요.");
    }

    @Test
    void calculateTest() {
        cal = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(cal.calculate()).isEqualTo(10);
    }

}
