package lotto.exception;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT_RANGE("구입 금액은 %d 이상 %d 이하만 가능합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 %d원 단위만 가능합니다.");

    private static final String MESSAGE_FORMAT = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }
}
