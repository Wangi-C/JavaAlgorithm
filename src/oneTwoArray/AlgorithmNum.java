package oneTwoArray;

public class AlgorithmNum {
    public int[] fiboArr;
    public int[] divArr;

    public static void main(String[] args) {
        AlgorithmNum AlgorithmNum = new AlgorithmNum();
        int n = 6;
        int[] arr = {7, 3, 9, 5, 6, 12};
        int[] arr2 = {1,0,1,1,1,0,0,1,1,0};
        int[] arr3 = {87, 89, 92, 100, 76, 87};

//        oneTwoArray.AlgorithmNum.fiboArr = new int[11];
//        oneTwoArray.AlgorithmNum.bigNum(n, arr);
//        oneTwoArray.AlgorithmNum.fiboSu(10);
//        for (int i : oneTwoArray.AlgorithmNum.fiboArr) {
//            System.out.print(i + " ");
//        }

        AlgorithmNum.divArr = new int[21];
//        oneTwoArray.AlgorithmNum.sosu2(100);
//        oneTwoArray.AlgorithmNum.countScore(arr2);
        AlgorithmNum.setGrade(6, arr3);
    }

    public void bigNum(int n, int[] array) {
        int preNum = 0;
        for (int i = 0; i < n; i++) {
            if (preNum < array[i]) {
                System.out.println("array = " + array[i]);
            }
            preNum = array[i];
        }
    }

    public int fiboSu(int n) {
        if (n==1) return fiboArr[n] = 1;
        else if (n==2) return fiboArr[n] = 1;
        else {
            return fiboArr[n] = fiboSu(n-1) + fiboSu(n-2);
        }
    }

    //소수_에라토스테네스 체
    public void sosu(int n) {
        int count = 0;
        for (int i = 2; i < n+1; i++) {
            if (divArr[i] == 1) {
                continue;
            } else {
                count++;

                int j = 1;
                while (true) {
                    int num = i * j;
                    if (num < n+1) {
                        divArr[num] = 1;
                    } else {
                        break;
                    }
                    j++;
                }
            }
        }

        System.out.println(count);
    }

    public void sosu2(int n) {
        //숫자 뒤집기.
        // res = res * 10 + t;
        // t = tmp % 10;
        // tmp = tmp / 10;
        int res = 0;
        int tmp = n;
        int t = 0;
        while (true) {
            if (tmp == 0) {
                break;
            } else {
                t = tmp % 10;
                tmp = tmp / 10;
                res = res * 10 + t;
            }
        }

        if (isPrime(res)) {
            System.out.println("res = " + res);
        }

    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i<num; i++) {
            if (num%i==0) return false;
        }
        return true;
    }

    public void countScore(int[] num) {
        // 반복문으로 하나씩 본다.
        // 다음 숫자가 1이면 score++;
        // 다음 숫자가 0이면 score = 0;
        // sum += score;
        int score = 0;
        int sum = 0;
        for (int i : num) {
            if (i == 1) {
                score++;
                sum += score;
            } else if (i == 0) {
                score = 0;
            }
        }
        sum += score;

        System.out.println("sum = " + sum);
    }

    public void setGrade(int n, int[] num) {
        // 2중for문 사용
        // 기준 숫자 지정하고, 다음 숫자와 비교해서 자신보다 클 경우 grade + 1;
        // 다음 숫자와 비교해서 자신보다 작은 경우 grade 그대로;
        // 해당 숫자의 answer[index] 에 grade 삽입
        int nowNum = 0;
        int grade = 1;
        int[] answer = new int[n];

        for (int i=0; i<num.length; i++) {
            nowNum = num[i];
            for (int j = 0; j<num.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (num[j] > nowNum) {
                        grade++;
                    }
                }
            }
            answer[i] = grade;
            grade = 1;
        }

        for (int n1 : num) {
            System.out.print(n1 + " ");
        }

        for (int n2 : answer) {
            System.out.print(n2 + " ");
        }
    }
}
