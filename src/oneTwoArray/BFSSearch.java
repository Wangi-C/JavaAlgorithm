package oneTwoArray;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSearch {
    // 1
    Node root;
    Queue<Node> q;
    //2
    int[] arr = new int[10001];
    Queue<Integer> locQ;
    //3
    Queue<Node> queue;
    int minLv = 10000;
    int nowLv;

    public void BFS(Node root) {
        int L = 0;
        q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.println("L = " + L);
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                System.out.println("node = " + node.data);
                if (node.lt != null) q.offer(node.lt);
                if (node.rt != null) q.offer(node.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFSSearch main = new BFSSearch();
//        1
//        main.root = new Node(1);
//        main.root.lt = new Node(2);
//        main.root.rt = new Node(3);
//        main.root.lt.lt = new Node(4);
//        main.root.lt.rt = new Node(5);
//        main.root.rt.lt = new Node(6);
//        main.root.rt.rt = new Node(7);

//        3
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);

        System.out.println(main.bfs(0, main.root));

//        main.BFS(main.root);
//        main.findCow(5, 14);
    }


    public void findCow(int me, int cow) {
        int L = 0;
        int[] way = {1, -1, 5};
        locQ = new LinkedList<>();
        locQ.offer(me);
        while (!locQ.isEmpty()) {
            int len = locQ.size();
            for (int i = 0; i< len; i++) {
                int loc = locQ.poll();

                for (int w : way) {
                    int mLoc = loc + w;
                    if (mLoc == cow) {
                        System.out.println(++L);
                        return;
                    }

                    if (arr[mLoc] == 0) {
                        arr[mLoc] = 1;
                        locQ.offer(mLoc);
                    }
                }
            }
            L++;
        }
    }

    public int dfs(int start, Node node) {
        //말단 노드까지 최단 거리.
        //말단 노드 : 가장 끝 노드(자식 노드가 없다.)에 도달했을때.
        if (node.lt == null && node.rt == null) {
            // 끝지점 도착
            minLv = Math.min(minLv, start);
        } else {
            dfs(start+1, node.lt);
            dfs(start+1, node.rt);
        }

        return minLv;
    }

    public int bfs(int start, Node node) {
        //queue 활용
        queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node n = queue.poll();
                if (n.lt == null && n.rt == null) return start;
                queue.offer(n.lt);
                queue.offer(n.rt);
            }
            start++;
        }

        return nowLv;
    }
}
