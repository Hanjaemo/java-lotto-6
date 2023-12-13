package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {

    private final Map<Rank, Integer> rankAndCount;

    public WinningResult(Map<Rank, Integer> rankAndCount) {
        this.rankAndCount = rankAndCount;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = rankAndCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount.getAmount() * 100;
    }

    public List<Integer> winningCounts() {
        for (Rank rank : Rank.values()) {
            rankAndCount.putIfAbsent(rank, 0);
        }

        return rankAndCount.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                .map(Entry::getValue)
                .toList();
    }
}
