package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        List<String> nameList = parseCarNames(carNames);
        return convertToCars(nameList);
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
    }

    private List<Car> convertToCars(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinnerNames(maxPosition);
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<String> findWinnerNames(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}

