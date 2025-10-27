package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        
        String carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();
        
        RacingGame game = new RacingGame(carNames);
        outputView.printResultMessage();
        
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
        
        outputView.printWinners(game.getWinners());
    }
}
