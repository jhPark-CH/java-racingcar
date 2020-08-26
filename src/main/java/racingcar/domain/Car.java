package racingcar.domain;

import racingcar.domain.status.CarMoveAbility;
import racingcar.domain.status.MoveAbility;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;

    private final String name;
    private int position;
    private final MoveAbility moveAbility;

    public Car(String name, int position, MoveAbility moveAbility) {
        this.name = name;
        this.position = position;
        this.moveAbility = moveAbility;
    }

    public static Car of(String name) {
        return new Car(name, START_POSITION, new CarMoveAbility());
    }

    public void move() {
        if (moveAbility.hasMoveAbility()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFirstPosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name) &&
                Objects.equals(moveAbility, car.moveAbility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, moveAbility);
    }
}
