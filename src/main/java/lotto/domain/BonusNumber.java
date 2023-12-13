package lotto.domain;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
    }

    public int getNumber() {
        return number;
    }
}
