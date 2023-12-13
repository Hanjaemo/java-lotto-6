package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^([1-9]+)(?:,([1-9]+))*$");

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToInt(input);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!WINNING_NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputView::convertToInt)
                .collect(Collectors.toList());
    }
}
