package lotto.domain;

import lotto.exception.ErrorMessage;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_BONUS_NUMBER_BY_RANGE.getMessage(),
                            Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
        }
    }

    public int getNumber() {
        return number;
    }
}
