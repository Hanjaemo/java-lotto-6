package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.LottoValidator;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
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
