package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
    }
}
