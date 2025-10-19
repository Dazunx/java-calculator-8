package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 입력값이_빈경우_0리턴() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2;6");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_한글자이상_사용() {
        assertSimpleTest(() -> {
            run("//--\\n1--4--12");
            assertThat(output()).contains("결과 : 17");
        });
    }
    @Test
    void 커스텀_구분자_개행문자_사용() {
        assertSimpleTest(() -> {
            run("//\\n\\n1\\n4\\n12");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 커스텀_구분자_슬래시_사용() {
        assertSimpleTest(() -> {
            run("////\\n1//4//12");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자와_구분자_외_문자_포함시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,A,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_있는경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;;;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀과_기본구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
