package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult check(Lotto winningLotto, BonusNumber bonusNumber) {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = lotto.check(winningLotto, bonusNumber.getNumber());
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return new WinningResult(winningResult);
    }
}
