package lotto.validation;

import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class LottoValidator {

    private LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throwIllegalException(String.format(ErrorMessage.INVALID_LOTTO_BY_SIZE.getMessage()));
        }
        if (hasNumberForInvalidRange(numbers)) {
            throwIllegalException(
                    String.format(ErrorMessage.INVALID_LOTTO_BY_RANGE.getMessage(),
                            Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
        }
        if (hasDuplicatedNumber(numbers)) {
            throwIllegalException(ErrorMessage.INVALID_LOTTO_BY_DUPLICATED.getMessage());
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != Lotto.SIZE;
    }

    private static boolean hasNumberForInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(LottoValidator::isOutOfRange);
    }

    private static boolean isOutOfRange(Integer number) {
        return number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER;
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != Lotto.SIZE;
    }

    private static void throwIllegalException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
