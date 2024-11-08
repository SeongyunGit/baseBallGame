import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class baseBallGameModel {
    public int randomNumberPick() {
        int randomNumber = 0;
        while (true) {
            BaseballRandomNumber baseballRandomNumber = new BaseballRandomNumber();
            randomNumber = baseballRandomNumber.getBaseballNumber();

            System.out.println(randomNumber);
            int hundred = randomNumber/100;
            int ten = (randomNumber/10)%10;
            int one = randomNumber%10;

            if (hundred != ten && ten != one && hundred != one) {
                break;
            }
        }
        return randomNumber;
    }
    public void randomNumberList(int[] randomArr, int randomNumber) {
        int number = 100;
        for (int j = 0; j < 3; j++) {
            randomArr[j] = randomNumber / number;
            int minus = number * randomArr[j];
            randomNumber -= minus;
            number /= 10;
        }
    }
    public void userNumberList(int userNumber, int[] userArr) {
        int userNumberset = 100;
        for (int i = 0; i < 3; i++) {
            userArr[i] = userNumber / userNumberset;
            int minus = userNumberset * userArr[i];
            userNumber -= minus;
            userNumberset /= 10;
        }
    }
    public void strikeAndBall(StrikeBall strikeBall, int[] userArr, int[] randomArr) {

        for (int i =0; i<3; i++) {
            if (userArr[i] == randomArr[i]) {
                strikeBall.plusStrike();

                if (userArr[(i+2)%3]==randomArr[(i+1)%3] && userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    strikeBall.plusBall();

                } else if (userArr[(i+2)%3]==randomArr[(i+1)%3] || userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    strikeBall.plusBall();
                }
            }
        }
    }
    public int findBall(int[] userArr, int[] randomArr, int ball) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (i!=j && userArr[i]==randomArr[j]) {
                    ball+=1;
                }
            }
        }
        return ball;
    }
}