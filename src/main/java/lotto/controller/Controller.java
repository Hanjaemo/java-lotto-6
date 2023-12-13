package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.exception.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = ExceptionHandler.handleIllegalArgumentException(this::getPurchaseAmount);

        LottoIssuer lottoIssuer = new LottoIssuer();
        Lottos lottos = lottoIssuer.issueLottos(purchaseAmount);
        OutputView.printNumberOfLottos(lottos.size());
        OutputView.printIssuedLottos(lottos.getLottos());

        Lotto winningLotto = ExceptionHandler.handleIllegalArgumentException(this::getWinningLotto);
        BonusNumber bonusNumber = ExceptionHandler.handleIllegalArgumentException(this::getBonusNumber);

        WinningResult winningResult = lottos.check(winningLotto, bonusNumber);
        double profitRate = winningResult.calculateProfitRate(purchaseAmount);

        List<Integer> matchCounts = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .map(Rank::getMatchCount)
                .sorted()
                .toList();
        List<Long> prizes = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .map(Rank::getPrize)
                .sorted()
                .toList();

        OutputView.printWinningResult(matchCounts, prizes, winningResult.winningCounts());
        OutputView.printProfitRate(profitRate);
    }

    private BonusNumber getBonusNumber() {
        return new BonusNumber(InputView.readBonusNumber());
    }

    private Lotto getWinningLotto() {
        return new Lotto(InputView.readWinningLotto());
    }

    private PurchaseAmount getPurchaseAmount() {
        return new PurchaseAmount(InputView.readPurchaseAmount());
    }
}
