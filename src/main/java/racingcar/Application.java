package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame("pobi,woni,jun");

        outputView.printResultMessage();

        for (int i = 0; i < 5; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }

        outputView.printWinners(game.getWinners());
    }
}
