package lotto.domain;

import lotto.exception.ErrorMessage;

public class BonusNumber {

    private static final int MIN_NUMBER = Lotto.MIN_NUMBER;
    private static final int MAX_NUMBER = Lotto.MAX_NUMBER;

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_BONUS_NUMBER_BY_RANGE.getMessage(),
                            MIN_NUMBER, MAX_NUMBER));
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
