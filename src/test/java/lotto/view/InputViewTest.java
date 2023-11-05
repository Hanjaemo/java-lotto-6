package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구입 금액을 성공적으로 입력 받으면, 그 값을 정수형으로 반환한다.")
    @Test
    void readPurchaseAmount_Success() {
        // given
        System.setIn(createUserInput("8000"));

        // when
        int purchaseAmount = InputView.readPurchaseAmount();

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(8000);
    }

    @DisplayName("구입 금액 입력 시 숫자가 아닌 다른 문자를 입력하면 예외가 발생한다.")
    @Test
    void readPurchaseAmount_Fail_ByNotInteger() {
        // given
        System.setIn(createUserInput("hi"));

        // when, then
        Assertions.assertThatThrownBy(InputView::readPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
    }

    @DisplayName("당첨 번호를 성공적으로 입력 받으면, 각 번호를 원소로 가지는 리스트를 반환한다.")
    @Test
    void readWinningNumbers_Success() {
        // given
        System.setIn(createUserInput("1,2,3,4,5,6"));

        // when
        List<Integer> winningNumbers = InputView.readWinningNumbers();

        // then
        Assertions.assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호 입력 시 숫자가 아닌 다른 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void readWinningNumbers_ByNotInteger() {
        // given
        System.setIn(createUserInput("1,f,2,6,7,10"));

        // when
        Assertions.assertThatThrownBy(InputView::readWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
