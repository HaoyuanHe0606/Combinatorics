import java.io.BufferedInputStream;
import java.util.Scanner;

class Main {
    private static int[] compute (int[] input, int n, long k) {
        if (k==0) return input;
        if (n==1) return input;

        int[] temp;
        temp = input.clone();

        for (int i = 0; i < n; i++) {

            while (k /factorial(n-i-1)>= 1) {
                int small = Integer.MAX_VALUE;
                int smallin = i;
                for (int j = i+1; j <n; j++)
                    if (temp[j] > temp[i] && temp[j] < small) {
                        small = temp[j];
                        smallin = j;
                    }

                if (smallin == i) {
                    int index;
                    int a = temp.length - 1;
                    int b = temp.length - 1;
                    while (a > 0 && temp[a - 1] >= temp[a])
                        a--;
                    index = a;

                    if (a <= 0)
                        break;
                    while (temp[b] <= temp[a - 1])
                        b--;

                    int store = temp[a - 1];
                    temp[a - 1] = temp[b];
                    temp[b] = store;

                    b = temp.length - 1;
                    while (a < b) {
                        store = temp[a];
                        temp[a] = temp[b];
                        temp[b] = store;
                        a++;
                        b--;
                    }
                    k--;
                    i = index;
                }
                else {
                    int store = temp[i];
                    temp[i] = temp[smallin];
                    temp[smallin] = store;
                    k -= factorial(n - i - 1);
                }
            }
        }
        return temp;
    }

    private static long factorial (int n) {
        long multi = 1;
        for (int i = 1; i <= n;i++)
            multi = multi *i;
        return multi;
    }
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n;
        long a;
        n = in.nextInt();
        a = in.nextLong();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        int[] out = (compute(input, n, a));
        for (int i = 0; i < n-1; i++) {
            System.out.print(out[i] + " ");
        }
        System.out.print(out[n-1]);
    }

}
