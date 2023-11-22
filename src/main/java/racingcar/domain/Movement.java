package racingcar.domain;

public enum Movement {
    GO(1),
    STOP(0);

    private final int moveAmount;

    Movement(int moveAmount) {
        this.moveAmount = moveAmount;
    }

    public int getMoveAmount() {
        return moveAmount;
    }
}
