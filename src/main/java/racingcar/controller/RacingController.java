package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Movable;
import racingcar.domain.RandomMovable;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final Movable movable = new RandomMovable();


    public void run() {
        // 1. 자동차 입력
        Cars cars = InputView.inputCars();

        // 2. 게임 실행
        play(cars);

        // 3. 우승자 출력
        OutputView.printWinnersDto(cars.toWinnersDto());
    }// 재귀로 변경 가능

    private void play(final Cars cars) {
        int maxRound = InputView.inputMaxRound();

        System.out.println("\n실행 결과");

        for (int i = 0; i < maxRound; i++) {
            cars.moveAllBy(movable);
            OutputView.printCarsDto(cars.toCarsDto());
            System.out.println();
        }
    }
}