package oneTwoArray;

public class topNum {
    public int[][] arr = new int[5][5];

    public static void main(String[] args) {
        topNum topNum = new topNum();
        topNum.arr[0] = new int[]{5, 3, 7, 2, 3};
        topNum.arr[1] = new int[]{3, 7, 1, 6, 1};
        topNum.arr[2] = new int[]{7, 2, 5, 3, 4};
        topNum.arr[3] = new int[]{4, 3, 6, 4, 1};
        topNum.arr[4] = new int[]{8, 7, 3, 5, 2};

        for (int j = 0; j < topNum.arr.length; j++) {
            for (int i = 0; i < topNum.arr.length; i++) {
                int value = topNum.arr[j][i];

                if (topNum.isBong(i, j, value)) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isBong(int x, int y, int value) {
        //좌
        if (x-1 >= 0) {
            if (value < arr[y][x-1]) {
                return false;
            }
        }

        //상
        if (y-1 >= 0) {
            if (value < arr[y-1][x]) {
                return false;
            }
        }

        //우
        if (x+1 < arr.length) {
            if (value < arr[y][x+1]) {
                return false;
            }
        }

        //하
        if (y+1 < arr.length) {
            if (value < arr[y+1][x]) {
                return false;
            }
        }

        return true;
    }
}