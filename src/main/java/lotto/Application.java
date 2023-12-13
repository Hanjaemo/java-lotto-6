package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoIssuer;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new LottoService(new LottoIssuer()));
        controller.run();
    }
}
