package oneTwoArray;

public class bbjh {
    public static int[] arr = null;
    public static int num = 3;

    public static void main(String[] args) {
        bbjh bbjh = new bbjh();
        arr = new int[4];
        bbjh.dfs(1);

    }

    public void dfs(int n) {
        if (n > num) {
            for (int i = 1; i < n; i++) {
                if (arr[i] == 1) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            return;
        } else {
            arr[n] = 1;
            dfs(n+1);
            arr[n] = 0;
            dfs(n+1);
        }
    }
}
