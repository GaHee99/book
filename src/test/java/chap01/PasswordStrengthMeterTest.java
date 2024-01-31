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
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    private void asserStrength(String password, PasswordStrength exptStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(exptStr, result);
    }

    @Test //테스트 환경 확인
    void name() {
    }

    @Test
    void 모든_규칙을_충족하는_경우() {
        asserStrength("ab123!@AB", PasswordStrength.STRONG);
    }

    @Test
    void 길이가_8글자_미만이고_다른_규칙은_모두_충족() {
        asserStrength("ab1!A", PasswordStrength.NORMAL);
    }

    @Test
    void 숫자는_포함하지_않고_다른_규칙은_모두_충족() {
        asserStrength("abcdACD!", PasswordStrength.NORMAL);
    }

    @Test
    void 값이_없는_경우() {
        assertEquals(null, PasswordStrength.INVALID);
    }

}
