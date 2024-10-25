package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {
    private Queue<String> input;
    private Integer result = 0;

    public StringCalculator(String input) {
        this.input = splitInputString(input);
    }

    public Queue<String> getInput() {
        return input;
    }

    public int getResult() {
        return result;
    }

    public int calculate() {
        int result = checkAndGetInt(input.poll());
        while (!input.isEmpty()) {
            Operator op = Operator.of(input.poll());
            int num = checkAndGetInt(input.poll());

            result = op.calculate(result, num);
        }
        return result;
    }

    private Queue<String> splitInputString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("수식을 입력해 주세요.");
        }

        String[] values = input.split(" ");
        if (values.length % 2 == 0) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return new LinkedList<>(Arrays.asList(values));
    }

    private int checkAndGetInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해 주세요.");
        }
    }
}
