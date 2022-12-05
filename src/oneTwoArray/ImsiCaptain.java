package oneTwoArray;

import java.util.Arrays;

public class ImsiCaptain {
    int[] visit = null;
    int[] imsiArr = null;

    public static void main(String[] args) {
        int[][] students = new int[5][5];
        students[0] = new int[]{2, 3, 1, 7, 3};
        students[1] = new int[]{4, 1, 9, 6, 8};
        students[2] = new int[]{5, 5, 2, 4, 4};
        students[3] = new int[]{6, 5, 2, 6, 7};
        students[4] = new int[]{8, 4, 2, 2, 2};

        ImsiCaptain imsiCaptain = new ImsiCaptain();
        imsiCaptain.visit = new int[students.length+1];
        imsiCaptain.imsiArr = new int[students.length+1];

        for (int i = 0; i < students[0].length; i++) {
            //학년 로테이션
            for (int j = 0; j < students.length; j++) {
                //학생 로테이션
                int s1 = students[j][i];
                imsiCaptain.visit[j+1] = 1;

                for (int x = j; x < students.length; x++) {
                    if (imsiCaptain.visit[x+1] > 0) {
                        continue;
                    }

                    if (s1 == students[x][i]) {
                        imsiCaptain.imsiArr[j+1] += 1;
                        imsiCaptain.imsiArr[x+1] += 1;
                    }
                }
            }

            imsiCaptain.visit = new int[students.length+1];
        }

        System.out.println(Arrays.toString(imsiCaptain.imsiArr));
    }
}
