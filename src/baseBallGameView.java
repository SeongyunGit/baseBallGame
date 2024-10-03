import java.util.Scanner;

public class baseBallGameView {
    static int userNumberScan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int userNumber = Integer.parseInt(sc.nextLine());
        return userNumber;
    }

    static boolean questionGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int resetGame = Integer.parseInt(sc.nextLine());
        if (resetGame == 2) {
            System.out.println("게임을 종료합니다.");
            return false;
        } if (resetGame != 1) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 게임 종료합니다.");
        }
        return true;
    }
    static void judgeStrikeAndBall(int strike, int ball) {
        if (strike>0 && ball>0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike==0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(strike + "스트라이크");
        }
    }
}
