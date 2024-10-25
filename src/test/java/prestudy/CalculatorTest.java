package prestudy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
<JUnit5>
- JUnit5는 Java 8 이상을 필요로 한다.
- JUnit5는 JUnit4와 달리 테스트 클래스나 메소드에 public 접근 제어자를 필요로 하지 않는다.
- JUnit5는 JUnit4와 달리 테스트 클래스나 메소드에 static 메소드를 사용할 필요가 없다.
- 애노테이션(Annotation)을 활용해 테스트 코드 구현
  - @Test
  - @BeforeEach, @AfterEach
- Assertions 클래스의 static assert method를 활용해 테스트 결과 검증

<JUnit4>
- 애노테이션(Annotation)을 활용해 테스트 코드 구현하는 방법은 JUnit 5.x와 같음
- 애노테이션의 패키지 위치와 이름만 다름. 다른 부분은 5.x와 같음
  - @org.junit.Test
  - @org.junit.Before, @org.junit.After
- Assert 클래스의 static assert method를 활용해 테스트 결과 검증
 */

public class CalculatorTest {
    Calculator cal;  // import를 하지 않았는데 어떻게 사용할 수 있을까? -> 같은 패키지 내에 있기 때문에 import가 필요 없다.

    @BeforeEach  // 각 테스트 메소드가 실행되기 전에 실행
    void setUp() {
        cal = new Calculator();
    }

    @Test
    public void 덧셈() {  // public 생략 가능
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    public void 뺄셈() {
        assertEquals(1, cal.subtract(4, 3));
    }

    @Test
    public void 곱셈() {
        assertEquals(12, cal.multiply(3, 4));
    }

    @Test
    void 나눗셈() {
        assertEquals(2, cal.divide(10, 5));
    }

    @AfterEach  // 각 테스트 메소드가 실행된 후에 실행
    void tearDown() {
        cal = null;
    }

}