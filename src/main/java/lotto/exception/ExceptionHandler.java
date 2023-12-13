package lotto.exception;

import java.util.function.Supplier;
import lotto.view.OutputView;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static <T> T handleIllegalArgumentException(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return handleIllegalArgumentException(reader);
        }
    }
}