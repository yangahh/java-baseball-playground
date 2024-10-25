package step1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    void ofTest() {
        assertEquals(Operator.of("+"), Operator.ADD);
        assertEquals(Operator.of("-"), Operator.SUBTRACT);
        assertEquals(Operator.of("*"), Operator.MULTIPLY);
        assertEquals(Operator.of("/"), Operator.DIVIDE);
    }

    @Test
    void ofExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> Operator.of("%"));
    }

    @Test
    void operatorTest() {
        assertEquals(Operator.ADD.calculate(2, 3), 5);
        assertEquals(Operator.SUBTRACT.calculate(2, 3), -1);
        assertEquals(Operator.MULTIPLY.calculate(2, 3), 6);
        assertEquals(Operator.DIVIDE.calculate(2, 3), 0);
    }

}