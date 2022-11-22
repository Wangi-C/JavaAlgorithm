import java.util.ArrayList;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String str = "teachermode";
        String s = "e";
        int cnt = 0;
        int reveerseCnt = 0;
        char[] strChar = str.toCharArray();
        int[] strAnswer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            //정방향으로 했을 때
            if (!s.equals(strChar[i]+"")) {
                cnt++;
                strAnswer[i] = cnt;
            } else {
                strAnswer[i] = 0;
                cnt = 0;
            }
        }

        for (int i = str.length()-1; i > -1; i--) {
            //역방향으로 했을 때
            if (!s.equals(strChar[i]+"")) {
                reveerseCnt++;
                strAnswer[i] = Math.min(strAnswer[i], reveerseCnt);
            } else {
                reveerseCnt = 0;
            }
        }

        for (int i : strAnswer) {
            System.out.println("i = " + i);
        }
    }
}
