package lotto.exception;

public enum ErrorMessage {
    INVALID_INPUT_PATTERN("입력 형식이 올바르지 않습니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_BY_RANGE("구입 금액은 %d 이상 %d 이하만 가능합니다."),
    INVALID_PURCHASE_AMOUNT_BY_UNIT("구입 금액은 %d원 단위만 가능합니다."),
    INVALID_BONUS_NUMBER_BY_RANGE("보너스 번호는 %d 이상 %d 이하만 가능합니다."),
    INVALID_LOTTO_BY_SIZE("로또 번호 개수는 %d개여야 합니다."),
    INVALID_LOTTO_BY_RANGE("로또 번호는 %d 이상 %d 이하만 가능합니다."),
    INVALID_LOTTO_BY_DUPLICATED("로또 번호는 중복될 수 없습니다.");

    private static final String MESSAGE_FORMAT = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }
}
