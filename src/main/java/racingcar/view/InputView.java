package racingcar.view;

import static racingcar.view.InputValidator.validateInputCars;
import static racingcar.view.InputValidator.validateInputNumber;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;

public class InputView {
    private static String readLine() {
        return Console.readLine().trim();
    }

    public static Cars inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        final String input = readLine();
        validateInputCars(input);

        return Cars.from(input);
    }

    public static int inputMaxRound() {
        System.out.println("시도할 회수는 몇회인가요?");

        final String input = readLine();
        validateInputNumber(input);

        return Integer.parseInt(input);
    }
}