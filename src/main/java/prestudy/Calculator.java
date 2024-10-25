package prestudy;

public class Calculator {

    // production code: 프로그램 구현을 담당하는 부분. 사용자가 실제로 사용하는 소스 코드를 의미
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    // test code: 프로덕션 코드가 정상적으로 동작하는지를 확인하는 코드
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(1, 2));
        System.out.println(cal.subtract(2, 1));
        System.out.println(cal.multiply(2, 3));
        System.out.println(cal.divide(10, 2));
        System.out.println(cal.divide(10, 3));
    }

    // 위 코드의 문제점
    // 1. production code와 test code가 하나의 클래스에 존재 -> 클래스의 크기가 커지고, 복잡도가 증가
    // 2. Test Code가 실 서비스에 같이 배포됨
    // 3. main method 하나에서 여러 개의 기능을 테스트 함 -> 복잡도 증가
    // 4. method 이름을 통해 어떤 부분을 테스트하는지에 대한 의도를 드러내기 힘듦
    // 5. 테스트 결과를 사람이 수동으로 확인해야 함

    // 이런 문제점들을 해결하기 위해 나온 도구가 JUnit 이다.

}
