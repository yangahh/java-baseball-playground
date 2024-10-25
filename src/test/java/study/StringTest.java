package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void replace() {
       String actual = "abc".replace("b", "d");
       assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String[] actual = "1,2,3".split(",");
        assertEquals(actual.length, 3);
        assertThat(actual).contains("2", "1", "3", "2");  // contains는 중복 여부, 순서와 상관없이 포함되어 있는지만 확인한다.
        assertThat(actual).containsExactly("1", "2", "3");  // 순서까지 정확히 일치하는지 확인한다.
        assertArrayEquals(actual, new String[] {"1", "2", "3"});  // 배열을 그냥 assertEquals로 비교하면 주소값을 비교하게 되므로 assertArrayEquals를 사용해야 한다.
    }

    @Test
    void substringTest() {
        String origin = "(1,2)";
        String result = origin.substring(1, origin.length() - 1);
        assertEquals(result, "1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void charAtTest() {
        String str = "abc";
        assertEquals(str.charAt(0), 'a');
        assertEquals(str.charAt(1), 'b');
        assertEquals(str.charAt(2), 'c');

        // 예외 테스트 : assertThatThrownBy(() -> { 예외가 발생할 코드 }).isInstanceOf(예외클래스).hasMessageContaining("예외 메시지");
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

        // 또는
        // assertThatExceptionOfType(예외클래스.class).isThrownBy(() -> { 예외가 발생할 코드 }).withMessageMatching("예외 메시지");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(3);
        }).withMessageMatching("String index out of range: 3");

        /*
        자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
        assertThatIllegalArgumentException()
        assertThatIllegalStateException()
        assertThatIOException()
        assertThatNullPointerException()
         */
    }

}
