package chap01;

import com.example.chap01.PasswordStrength;
import com.example.chap01.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 검사할 규칙
 *  - 길이가 8글자 이상
 *  - 0-9사이 숫자 포함
 *  - 대문자 포함
 *
 * 2. 세개 규칙 모두 충족 = 강함
 *    두개 규칙 충족 = 보통
 *    한개 규칙 충족 = 약함
 */
public class PasswordStrengthMeterTest {

    @Test //테스트 환경 확인
    void name() {
    }

    // 1. 첫번째 테스트 모든 규칙을 충족하는 경우
    @Test
    void 모든_규칙을_충족하는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);

        PasswordStrength result2 = meter.meter("ab123!@AB");
        assertEquals(PasswordStrength.STRONG, result2);
    }

    // 2. 길이만 8글자 미만일 때
    @Test
    void 길이가_8글자_미만이고_다른_규칙은_모두_충족() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab1!A");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
