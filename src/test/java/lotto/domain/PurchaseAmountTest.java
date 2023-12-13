package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("로또 구입 금액이 정상적으로 생성된다.")
    @Test
    void createPurchaseAmount_Success() {
        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        // then
        Assertions.assertThat(purchaseAmount.getAmount()).isEqualTo(1000);
    }

    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByLessThanMinimum() {
        // given
        int purchaseAmount = 999;

        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 100000원 초과이면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByGreaterThanMaximum() {
        // given
        int purchaseAmount = 100001;

        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_Fail_ByNotMultipleOfLottoPrice() {
        // given
        int purchaseAmount = 1001;

        // when, then
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액을 입력받아 구입한 로또 개수를 반환한다.")
    @Test
    void divide_Success() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

        // when
        int lottoCount = purchaseAmount.divide(Lotto.PRICE);

        // then
        Assertions.assertThat(lottoCount).isEqualTo(14);
    }
}