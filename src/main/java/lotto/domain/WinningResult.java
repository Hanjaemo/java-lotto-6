package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {

    public static final int PERCENTAGE = 100;
    private final Map<Rank, Integer> rankAndCount;

    public WinningResult(Map<Rank, Integer> rankAndCount) {
        this.rankAndCount = rankAndCount;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount.getAmount() * PERCENTAGE;
    }

    private long calculateTotalPrize() {
        return rankAndCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public List<Integer> winningCounts() {
        putAll();
        return rankAndCount.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                .map(Entry::getValue)
                .toList();
    }

    private void putAll() {
        for (Rank rank : Rank.values()) {
            rankAndCount.putIfAbsent(rank, 0);
        }
    }
}
