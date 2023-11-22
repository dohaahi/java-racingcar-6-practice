package racingcar.exception;

public class IllegalInputException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 입력입니다.";

    public IllegalInputException() {
        super(EXCEPTION_MESSAGE);
    }
}