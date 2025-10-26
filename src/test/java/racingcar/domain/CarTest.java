package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성시_이름이_저장된다() {
        String carName = "pobi";
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차_생성시_위치는_0이다() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가_전진한다() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        for (int i = 0; i < 10; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
    }
}

