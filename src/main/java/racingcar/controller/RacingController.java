package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        String carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();

        RacingGame game = new RacingGame(carNames);
        
        outputView.printResultMessage();
        playGame(game, attemptCount);
        outputView.printWinners(game.getWinners());
    }

    private void playGame(RacingGame game, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
    }
}

