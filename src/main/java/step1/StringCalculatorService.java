package step1;

import java.util.Scanner;

public class StringCalculatorService {
    private final Scanner scanner;
    private static StringCalculator cal;

    public StringCalculatorService() {
        this.scanner = new Scanner(System.in);
    }

    private void setCal(String input) {
        cal = new StringCalculator(input);
    }

    public void run() {
        System.out.println("계산할 식을 입력해주세요.");
        String input = scanner.nextLine();

        try {
            setCal(input);
            print(cal.calculate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("계산을 종료합니다.");
    }

    public void print(int result) {
        System.out.println("결과: " + result);
    }
}
