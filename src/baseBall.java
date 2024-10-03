public class baseBall {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseBallGameController.gameStart();
        int resetGame = baseBallGameView.questionGameOver();
        if (resetGame==2) {
            System.out.println("게임을 종료합니다.");
        } else if (resetGame!=1) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 게임 종료합니다.");
        }
    }
}

