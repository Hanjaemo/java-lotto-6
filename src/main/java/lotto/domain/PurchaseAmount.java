package lotto.domain;

import lotto.exception.ErrorMessage;

public class PurchaseAmount {

    private static final int MINIMUM_AMOUNT = Lotto.PRICE;
    private static final int MAXIMUM_AMOUNT = 100_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isOutOfRange(amount)) {
            throwIllegalException(
                    String.format(ErrorMessage.INVALID_PURCHASE_AMOUNT_BY_RANGE.getMessage(),
                            MINIMUM_AMOUNT, MAXIMUM_AMOUNT));
        }
        if (isNotMultipleOfLottoPrice(amount)) {
            throwIllegalException(
                    String.format(ErrorMessage.INVALID_PURCHASE_AMOUNT_BY_UNIT.getMessage(), Lotto.PRICE));
        }
    }

    private boolean isOutOfRange(int amount) {
        return amount < MINIMUM_AMOUNT || amount > MAXIMUM_AMOUNT;
    }

    private boolean isNotMultipleOfLottoPrice(int amount) {
        return amount % Lotto.PRICE != 0;
    }

    private void throwIllegalException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    public int divide(int amount) {
        return this.amount / amount;
    }

    public int getAmount() {
        return amount;
    }
}
