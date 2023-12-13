package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int size() {
        return lottos.size();
    }

    public List<List<Integer>> getLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
