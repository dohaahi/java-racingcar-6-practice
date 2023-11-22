package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovable implements Movable {
    @Override
    public Movement nextMovement() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            return Movement.GO;
        }

        return Movement.STOP;
    }
}