public class baseBall {

    public static void main(String[] args) {
        baseBallGameModel model = new baseBallGameModel();
        baseBallGameView view = new baseBallGameView();
        baseBallGameController controller = new baseBallGameController(model, view);
        System.out.println("숫자 야구 게임을 시작합니다.");
        controller.gameStart();
    }
}

