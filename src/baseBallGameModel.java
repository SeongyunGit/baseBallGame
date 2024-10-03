import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class baseBallGameModel {
    static int randomNumberPick() {
        Random random = new Random();
        int randomNumber = random.nextInt(899)+100;
        System.out.println(randomNumber);
        while (true) {
            int hundred = randomNumber/100;
            int ten = (randomNumber/10)%10;
            int one = randomNumber%10;

            if (hundred != ten && ten != one && hundred != one) {
                break;
            }
        }
        return randomNumber;
    }
    static void randomNumberList(int[] randomArr, int randomNumber) {
        int number = 100;
        for (int j = 0; j < 3; j++) {
            randomArr[j] = randomNumber / number;
            int minus = number * randomArr[j];
            randomNumber -= minus;
            number /= 10;
        }
    }
    static void userNumberList(int userNumber, int[] userArr) {
        int userNumberset = 100;
        for (int i = 0; i < 3; i++) {
            userArr[i] = userNumber / userNumberset;
            int minus = userNumberset * userArr[i];
            userNumber -= minus;
            userNumberset /= 10;
        }
    }
    static List<Integer> strikeAndBall(int[] userArr, int[] randomArr) {
        List<Integer> strikeBall = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i =0; i<3; i++) {
            if (userArr[i] == randomArr[i]) {
                strike += 1;
                if (userArr[(i+2)%3]==randomArr[(i+1)%3] && userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    ball += 2;
                } else if (userArr[(i+2)%3]==randomArr[(i+1)%3] || userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    ball += 1;
                }
            }
        }
        strikeBall.add(strike);
        strikeBall.add(ball);
        return strikeBall;
    }
    static int findBall(int[] userArr, int[] randomArr, int ball) {
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
