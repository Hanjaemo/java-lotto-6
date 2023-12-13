package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfLottos(int numberOfLottos) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLottos);
    }

    public static void printIssuedLottos(List<List<Integer>> lottos) {
        lottos.forEach(System.out::println);
    }
}
