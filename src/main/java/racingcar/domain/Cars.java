package racingcar.domain;

import racingcar.constant.RacingMessage;
import racingcar.util.Splitter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public Cars(String carNames) {
        this.cars = Collections.unmodifiableList(readyCars(carNames));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private List<Car> readyCars(String carNames) {
        List<String> names = Splitter.splitText(carNames);
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.isFirstPosition(findFirstPositionCar()))
                .collect(Collectors.toList());
    }

    public Car findFirstPositionCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new NoSuchElementException(RacingMessage.NOT_FOUND_FIRST_POSITION_CAR));
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.move();
        }
    }
}
