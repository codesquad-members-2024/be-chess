package chess.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainCommandTest {

    @Test
    @DisplayName("커맨드를 입력하면 해당하는 객체를 반환한다..")
    void of() {
        assertThat(MainCommand.of("end")).isEqualTo(MainCommand.END);
        assertThat(MainCommand.of("Start")).isEqualTo(MainCommand.START);
    }

    @Test
    @DisplayName("잘못된 커맨드를 입력하면 예외를 발생시킨다.")
    void of_invalid() {
        assertThatThrownBy(() -> MainCommand.of("final")).isInstanceOf(IllegalArgumentException.class);
    }

}