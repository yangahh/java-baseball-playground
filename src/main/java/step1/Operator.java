package step1;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private IntBinaryOperator operation;

    Operator(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 연산자는 존재하지 않습니다."));
    }

    public int calculate(int a, int b) {
        return operation.applyAsInt(a, b);
    }
}
