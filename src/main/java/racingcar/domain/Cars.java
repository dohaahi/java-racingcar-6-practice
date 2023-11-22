package racingcar.domain;

import static racingcar.view.InputValidator.validateCars;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(Car::from)
                .toList();

        validateCars(input);

        return new Cars(cars);
    }

    public void moveAllBy(Movable movable) {
        for (Car car : cars) {
            car.moveBy(movable.nextMovement());
        }
    }

    public CarsDto toCarsDto() {
        List<CarDto> carDtos = cars.stream()
                .map(Car::toCarsDto)
                .toList();

        return new CarsDto(carDtos);
    }

    public WinnersDto toWinnersDto() {
        int maxPosition = calcMaxPosition();

        List<WinnerDto> winnerCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::toWinnerDto)
                .toList();

        return new WinnersDto(winnerCars);
    }

    private int calcMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}