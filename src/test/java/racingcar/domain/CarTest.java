package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.status.MoveAbility;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @DisplayName("Car start position 테스트")
    @Test
    void noArgsConstructorTest() {
        car = Car.of("유재석");
        assertThat(car.getPosition())
                .isZero();
    }

    @DisplayName("이름을 입력받은 Car 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"유재석", "이효리"})
    void createCarTest(String name) {
        car = Car.of(name);
        assertThat(car.getName())
                .isEqualTo(name);
    }

    @DisplayName("Car 전진 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"유재석"})
    void carMoveTest(String name) {
        MoveAbility positiveMoveAbility = () -> true;
        car = new Car(name, 0, positiveMoveAbility);
        car.move();
        assertThat(car.getPosition())
                .isOne();
    }
}
