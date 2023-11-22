package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.CarsDto;
import racingcar.domain.WinnerDto;
import racingcar.domain.WinnersDto;

public class OutputView {
    public static void printWinnersDto(final WinnersDto winnersDto) {
        System.out.print("최종 우승자 : ");

        String winners = winnersDto.winners().stream().map(WinnerDto::name).collect(Collectors.joining(","));

        System.out.println(winners);
    }

    public static void printCarsDto(final CarsDto carsDto) {
        carsDto.cars()
                .forEach(carDto -> System.out.printf("%s : %s\n", carDto.name(), positionConvertor(carDto.position())));
    }

    private static String positionConvertor(final int position) {
        return "-".repeat(position);
    }
}