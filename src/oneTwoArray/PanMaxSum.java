package oneTwoArray;

public class PanMaxSum {
    public int[][] arr = new int[5][5];
    public int[] hapArr = new int[5];

    public static void main(String[] args) {
        PanMaxSum panMaxSum = new PanMaxSum();
        panMaxSum.arr[0] = new int[]{10, 13, 10, 12, 15};
        panMaxSum.arr[1] = new int[]{12, 39, 30, 23, 11};
        panMaxSum.arr[2] = new int[]{11, 25, 50, 53, 15};
        panMaxSum.arr[3] = new int[]{19, 27, 29, 37, 27};
        panMaxSum.arr[4] = new int[]{19, 13, 30, 13, 19};

        System.out.println(panMaxSum.solution(5, panMaxSum.arr));
    }

    public int solution(int n, int[][] arr) {
        // Math.max(hap[i], (왼쪽, 오른쪽))
        // 0번쩨 or n-1번째 는 대각선까지 비교
        for (int i = 0; i < n; i++) {
            //가로합
            int maxHap = hapArr[i];
            int hap = 0;
            for (int j = 0; j < n; j++) {
                hap += arr[i][j];
            }
            maxHap = Math.max(maxHap, hap);
            hap = 0;
            for (int x = 0; x < n; x++) {
                hap += arr[x][i];
            }
            maxHap = Math.max(maxHap, hap);

            if (i==0 || i==(n-1)) {
                // 0번쩨 or n-1번째 는 대각선까지 비교
                //왼쪽대각선 [0][0], [1][1], ...
                hap = 0;
                for (int y = 0; y < n; y++) {
                    hap += arr[y][y];
                }
                maxHap = Math.max(maxHap, hap);

                hap = 0;
                for (int y = 0; y < n; y++) {
                    hap += arr[y][(n-1)-y];
                }
                maxHap = Math.max(maxHap, hap);
            }

            hapArr[i] = maxHap;
        }

        int max = 0;
        for (int h : hapArr) {
            max = Math.max(max, h);
        }

        return max;
    }
}
