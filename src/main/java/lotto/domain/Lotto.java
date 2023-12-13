package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        if (numbers.stream().anyMatch(this::isOutOfRange)) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        if (Set.copyOf(numbers).size() != SIZE) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
    }

    private boolean isOutOfRange(Integer number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public Rank check(Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean hasBonusNumber = numbers.contains(bonusNumber);
        return Rank.of(matchCount, hasBonusNumber);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
