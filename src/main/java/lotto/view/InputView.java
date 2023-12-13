package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;

public class InputView {

    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^([0-9]+)(?:,([0-9]+))*$");

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = getReadLine();
        return convertToInt(input);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getReadLine();
        validateInputPattern(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputView::convertToInt)
                .collect(Collectors.toList());
    }

    private static String getReadLine() {
        return Console.readLine();
    }

    private static void validateInputPattern(String input) {
        if (!WINNING_NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PATTERN.getMessage());
        }
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = getReadLine();
        return convertToInt(input);
    }
}
