package lotto.domain;

import java.util.Map;

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
}
