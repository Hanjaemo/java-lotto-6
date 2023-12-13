package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoIssuer {

    public Lottos issueLottos(PurchaseAmount purchaseAmount) {
        int numberOfLottos = purchaseAmount.divide(Lotto.PRICE);
        return new Lottos(IntStream.range(0, numberOfLottos)
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList()));
    }

    private Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE));
    }
}
