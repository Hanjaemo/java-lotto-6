package lotto.domain;

import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> rankAndCount;

    public WinningResult(Map<Rank, Integer> rankAndCount) {
        this.rankAndCount = rankAndCount;
    }
}
