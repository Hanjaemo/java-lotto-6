package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) { // TODO 클래스 분리
        if (isInvalidSize(numbers)) {
            throwIllegalException(String.format(ErrorMessage.INVALID_LOTTO_BY_SIZE.getMessage()));
        }
        if (hasNumberForInvalidRange(numbers)) {
            throwIllegalException(
                    String.format(ErrorMessage.INVALID_LOTTO_BY_RANGE.getMessage(), MIN_NUMBER, MAX_NUMBER));
        }
        if (hasDuplicatedNumber(numbers)) {
            throwIllegalException(ErrorMessage.INVALID_LOTTO_BY_DUPLICATED.getMessage());
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private boolean hasNumberForInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(Integer number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != SIZE;
    }

    private void throwIllegalException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    public Rank check(Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean hasBonusNumber = numbers.contains(bonusNumber);
        return Rank.of(matchCount, hasBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
