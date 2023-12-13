package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());

        LottoIssuer lottoIssuer = new LottoIssuer();
        Lottos lottos = lottoIssuer.issueLottos(purchaseAmount);
        OutputView.printNumberOfLottos(lottos.size());
        OutputView.printIssuedLottos(lottos.getLottos());

        Lotto winningLotto = new Lotto(InputView.readWinningLotto());
    }
}
