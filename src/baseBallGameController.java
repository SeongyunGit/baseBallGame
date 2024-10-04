import java.util.List;

public class baseBallGameController {
    private  final baseBallGameModel model;
    private  final baseBallGameView view;

    public baseBallGameController(baseBallGameModel model, baseBallGameView view) {
        this.model = model;
        this.view = view;
    }

    public  void gameStart() {
        while (true) {
            int randomNumber = model.randomNumberPick();
            int[] randomArr = new int[3];
            model.randomNumberList(randomArr, randomNumber);

            while (true) {

                int userNumber = view.userNumberScan();

                int[] userArr = new int[3];
                model.userNumberList(userNumber, userArr);

                List<Integer> strikeBall = model.strikeAndBall(userArr, randomArr);
                int strike = strikeBall.get(0);
                int ball = strikeBall.get(1);

                if (strike == 0) {
                    ball = model.findBall(userArr, randomArr, ball);
                }
                if (strike == 3) {
                    break;
                }
                view.judgeStrikeAndBall(strike, ball);
            }
            boolean resetGame = view.questionGameOver();
            if (!resetGame) {
                break;
            }
        }
    }
}
