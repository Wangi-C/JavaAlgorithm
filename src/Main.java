public class Main {
    static int[] fibo;

    Node root;

    public void dfs4(Node root) {

        if (root.lt == null) {
            System.out.print(root.data + " ");
            return;
        } else if (root.rt == null) {
            System.out.print(root.data + " ");
            return;
        } else {
            dfs4(root.lt);
            System.out.print(root.data + " ");
            dfs4(root.rt);

        }

    }

    public static void main(String[] args) {

        Main main = new Main();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);
        main.dfs4(main.root);
    }

    public void dfs1(int n) {
//      이진수
        if (n/2==0) {
            System.out.print(n%2);
            return;
        } else {
            dfs1(n/2);
            System.out.print(n%2);
        }
    }

    public int dfs2(int n) {
//        재귀호출.
        if (n==1) {
            return 1;
        } else {
            return n*dfs2(n-1);
        }
    }

    public void fiboN(int n) {
        fibo = new int[n+1];
        dfs3(n);
        for (int i = 1; i<=10; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int dfs3(int n) {
        //피보나치 수열
        // 1. return fibo(n-1) + fibo(n-2) -> (전 숫자 + 전전 숫자) 가지를 뻗으며 더해간다.
        // (45)했을 때, 너무 오래 걸림
        // 2. 메로리를 활용해서 이미 더했던 건, 꺼내서 재사용.
        //    return fibo[n] = dfs(n-1) + dfs(n-2); if (fibo[n] > 0) return fibo[n]
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n==1) {
            return fibo[1] = 1;
        } else if (n==2) {
            return fibo[2] = 1;
        } else {

            return fibo[n] = dfs3(n-2)+dfs3(n-1);
        }
    }
}

class Node{
    int data;
    Node lt,rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}