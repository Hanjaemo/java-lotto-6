package lotto.view;

import java.text.DecimalFormat;
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

    public static void printWinningResult(List<Integer> matchCounts,
                                          List<Long> prizes,
                                          List<Integer> winningCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < matchCounts.size(); i++) {
            if (i == 3) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개%n",
                        matchCounts.get(i),
                        convertNumberToKoreanWonFormat(prizes.get(i)),
                        winningCounts.get(i));
            }
            System.out.printf("%d개 일치 (%s) - %d개%n",
                    matchCounts.get(i),
                    convertNumberToKoreanWonFormat(prizes.get(i)),
                    winningCounts.get(i));
        }
    }

    private static String convertNumberToKoreanWonFormat(long amount) {
        return new DecimalFormat("#,###원").format(amount);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
