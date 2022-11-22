package oneTwoArray;

public class Fibo {
    // 1 1 2 3 5 8 -> fibo
    int[] fiboArr = null;

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        fibo.fiboArr = new int[6];
        fibo.dfs(5);

        for (int i : fibo.fiboArr) {
            System.out.println(i + " ");
        }
    }

    public int dfs(int n) {
        if (fiboArr[n] > 0) {
            return fiboArr[n];
        }

        if (n == 1) {
            return fiboArr[1] = 1;
        } else if (n==2) {
            return fiboArr[2] = 1;
        } else {
            return fiboArr[n] = dfs(n-2) + dfs(n-1);
        }
    }
}
