package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningResult;

public class LottoService {

    private final LottoIssuer lottoIssuer;

    public LottoService(LottoIssuer lottoIssuer) {
        this.lottoIssuer = lottoIssuer;
    }

    public Lottos issueLottos(PurchaseAmount purchaseAmount) {
        return lottoIssuer.issueLottos(purchaseAmount);
    }

    public WinningResult checkLottos(Lotto winningLotto, BonusNumber bonusNumber, Lottos lottos) {
        return lottos.check(winningLotto, bonusNumber);
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        return winningResult.calculateProfitRate(purchaseAmount);
    }
}
