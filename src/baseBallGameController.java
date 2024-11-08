import java.util.List;

public class baseBallGameController {
    private final baseBallGameModel model;
    private final baseBallGameView view;

    public baseBallGameController(baseBallGameModel model, baseBallGameView view) {
        this.model = model;
        this.view = view;
    }

    public void gameStart() {
        while (true) {
            int randomNumber = model.randomNumberPick();
            UserNumberList userNumberList = new UserNumberList();

            int[] randomArr = userNumberList.getUserNumberList();
            model.randomNumberList(randomArr, randomNumber);

            while (true) {

                int userNumber = view.userNumberScan();

                RandomNumberList randomNumberList = new RandomNumberList();

                int[] userArr=randomNumberList.getRandomNumberList();

                model.userNumberList(userNumber, userArr);

                StrikeBall strikeBall = new StrikeBall();
                model.strikeAndBall(strikeBall, userArr, randomArr);
                int strike = strikeBall.getStrike();
                int ball = strikeBall.getBall();


                if (strike == 0) {
                    ball = model.findBall(randomNumberList.getRandomNumberList(), randomArr, ball);
                }
                view.judgeStrikeAndBall(strike, ball);

                if (strike == 3) {
                    break;
                }
            }
            boolean resetGame = view.questionGameOver();
            if (!resetGame) {
                break;
            }
        }
    }
}
