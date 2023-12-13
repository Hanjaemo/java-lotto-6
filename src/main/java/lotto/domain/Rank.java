package lotto.domain;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000L, (matchCount, hasBonusNumber) -> matchCount == 6),
    SECOND(5, 30_000_000L, (matchCount, hasBonusNumber) -> matchCount == 5 && hasBonusNumber),
    THIRD(5, 1_500_000L, (matchCount, hasBonusNumber) -> matchCount == 5),
    FOURTH(4, 50_000L, (matchCount, hasBonusNumber) -> matchCount == 4),
    FIFTH(3, 5_000L, (matchCount, hasBonusNumber) -> matchCount == 3),
    MISS(0, 0L, (matchCount, hasBonusNumber) -> matchCount < 3);

    private final int matchCount;
    private final long prize;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int matchCount, long prize, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.condition = condition;
    }

    public static Rank of(int matchCount, boolean hasBonusNumber) {
        return Stream.of(values())
                .filter(rank -> rank.condition.test(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(MISS);
    }
}
