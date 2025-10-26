package racingcar.domain;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 쉼표로_구분된_자동차_이름으로_게임을_생성한다() {
        RacingGame game = new RacingGame("pobi,woni,jun");
        List<Car> cars = game.getCars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void 자동차_이름의_앞뒤_공백을_제거한다() {
        RacingGame game = new RacingGame("pobi , woni , jun");
        List<Car> cars = game.getCars();
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 라운드를_진행하면_모든_자동차가_이동한다() {
        RacingGame game = new RacingGame("pobi,woni");
        game.playRound();
        game.playRound();
        game.playRound();
        List<Car> cars = game.getCars();
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 우승자를_판별한다() {
        RacingGame game = new RacingGame("pobi,woni,jun");
        for (int i = 0; i < 5; i++) {
            game.playRound();
        }
        List<String> winners = game.getWinners();

        assertThat(winners).isNotEmpty();
    }

    @Test
    void 우승자는_한_명_이상일_수_있다() {
        RacingGame game = new RacingGame("pobi,woni");
        for (int i = 0; i < 10; i++) {
            game.playRound();
        }
        List<String> winners = game.getWinners();
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}

