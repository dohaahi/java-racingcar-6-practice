package racingcar.domain;

import static racingcar.view.InputValidator.validateCar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        validateCar(name);
        return new Car(name);
    }

    public void moveBy(Movement movement) {
        position += movement.getMoveAmount();
    }

    public CarDto toCarsDto() {
        return new CarDto(name, position);
    }

    public WinnerDto toWinnerDto() {
        return new WinnerDto(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}