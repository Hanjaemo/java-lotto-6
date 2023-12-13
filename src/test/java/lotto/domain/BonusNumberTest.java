package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 정상적으로 생성된다.")
    @Test
    void createBonusNumber_Success() {
        // given
        int bonusNumber = 7;

        // when
        BonusNumber bonus = new BonusNumber(bonusNumber);

        // then
        Assertions.assertThat(bonus.getNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumber_Fail_ByLessThanMinimum() {
        // given
        int bonusNumber = 0;

        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createBonusNumber_Fail_ByGreaterThanMaximum() {
        // given
        int bonusNumber = 46;

        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}