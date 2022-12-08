package TwoPointerSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointerAlgorithm {
    public static void main(String[] args) {
        TwoPointerAlgorithm twoPointerAlgorithm = new TwoPointerAlgorithm();
//        twoPointerAlgorithm.firshSolution(3, new int[]{1, 3, 5}, 5, new int[]{2,3,6,7,9});
        twoPointerAlgorithm.secodSolution(5, new int[]{1, 3, 9, 5, 2}, 5, new int[]{3, 2, 5, 7, 8});
    }

    public void firshSolution(int n, int[] oneArr, int m, int[] twoArr) {
        int i = 0;
        int j = 0;
        int x = 0;

        int[] resultArr = new int[n+m];

        while (true) {
            if (i == n) {
                for(int k = j; k < m; k++) {
                    resultArr[x] = twoArr[k];
                    x++;
                }

                break;
            } else if (j == m) {
                for(int k = i; k < i; k++) {
                    resultArr[x] = twoArr[k];
                    x++;
                }

                break;
            }

            int oneNum = oneArr[i];
            int twoNum = twoArr[j];
            resultArr[x] = Math.min(oneNum,twoNum);

            if (oneNum >= twoNum) {
                j++;
            } else if (oneNum < twoNum) {
                i++;
            }
            x++;
        }

        for (int num : resultArr) {
            System.out.println("num = " + num);
        }
    }

    public void secodSolution(int n, int[] oneArr, int m, int[] twoArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(oneArr);
        Arrays.sort(twoArr);

        int p1 = 0;
        int p2 = 0;

        while (true) {
            if (p1 == n || p2 == m) {
                break;
            }

            if (oneArr[p1] == twoArr[p2]) {
                arrayList.add(oneArr[p1]);
                p1++;
                p2++;
            } else if (oneArr[p1] < twoArr[p2]) {
                p1++;
            } else if (oneArr[p1] > twoArr[p2]) {
                p2++;
            }
        }

        System.out.println("arrayList = " + arrayList);
    }
}
