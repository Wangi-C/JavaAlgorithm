import java.util.*;

class Solution {
    public void solution(int n) {
        if (n > 0) {
            solution(n--);
            System.out.println(n);
        } else {
            System.out.println(n);
        }
    }



    public String solutionT(String str) {
        String answer = null;
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }

        return null;
    }
}