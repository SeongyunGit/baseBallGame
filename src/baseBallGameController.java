import java.util.List;

public class baseBallGameController {
    private static baseBallGameModel model;
    private static baseBallGameView view;

    public baseBallGameController(baseBallGameModel model, baseBallGameView view) {
        this.model = model;
        this.view = view;
    }

    static void gameStart() {
        while (true) {
            int randomNumber = model.randomNumberPick();
            int[] randomArr = new int[3];
            model.randomNumberList(randomArr, randomNumber);

            while (true) {

                int userNumber = view.userNumberScan();

                int[] userArr = new int[3];
                baseBallGameModel.userNumberList(userNumber, userArr);

                List<Integer> strikeBall = baseBallGameModel.strikeAndBall(userArr, randomArr);
                int strike = strikeBall.get(0);
                int ball = strikeBall.get(1);

                if (strike == 0) {
                    ball = baseBallGameModel.findBall(userArr, randomArr, ball);
                }
                if (strike == 3) {
                    break;
                }
                baseBallGameView.judgeStrikeAndBall(strike, ball);
            }
            int resetGame = baseBallGameView.questionGameOver();
            if (resetGame == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (resetGame != 1) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 게임 종료합니다.");
            }
        }
    }
}
