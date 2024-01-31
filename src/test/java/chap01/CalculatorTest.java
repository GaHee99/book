package chap01;

import com.example.chap02.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void plus() {
        int result = Calculator.plus(1,2);
        assertEquals(result,3);
        assertEquals(Calculator.plus(3,5), 8);
    }
}
