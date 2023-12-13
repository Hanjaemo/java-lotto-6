package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoService lottoService;

    public Controller(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = ExceptionHandler.handleIllegalArgumentException(this::getPurchaseAmount);
        Lottos lottos = issueLottos(purchaseAmount);

        WinningResult winningResult = check(lottos);
        double profitRate = lottoService.calculateProfitRate(purchaseAmount, winningResult);

        printWinningResult(winningResult, profitRate);
    }

    private PurchaseAmount getPurchaseAmount() {
        return new PurchaseAmount(InputView.readPurchaseAmount());
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = lottoService.issueLottos(purchaseAmount);
        OutputView.printNumberOfLottos(lottos.size());
        OutputView.printIssuedLottos(lottos.getLottos());
        return lottos;
    }

    private WinningResult check(Lottos lottos) {
        Lotto winningLotto = ExceptionHandler.handleIllegalArgumentException(this::getWinningLotto);
        BonusNumber bonusNumber = ExceptionHandler.handleIllegalArgumentException(this::getBonusNumber);

        return lottoService.checkLottos(winningLotto, bonusNumber, lottos);
    }

    private Lotto getWinningLotto() {
        return new Lotto(InputView.readWinningLotto());
    }

    private BonusNumber getBonusNumber() {
        return new BonusNumber(InputView.readBonusNumber());
    }

    private void printWinningResult(WinningResult winningResult, double profitRate) {
        List<Integer> matchCounts = Rank.matchCounts();
        List<Long> prizes = Rank.prizes();

        OutputView.printWinningResult(matchCounts, prizes, winningResult.winningCounts());
        OutputView.printProfitRate(profitRate);
    }
}
