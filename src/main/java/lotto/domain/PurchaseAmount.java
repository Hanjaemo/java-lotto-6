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
        if (amount < MINIMUM_AMOUNT || amount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage(),
                            MINIMUM_AMOUNT, MAXIMUM_AMOUNT));
        }
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage(), Lotto.PRICE));
        }
    }

    public int divide(int amount) {
        return this.amount / amount;
    }

    public int getAmount() {
        return amount;
    }
}
