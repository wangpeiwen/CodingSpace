import java.util.Scanner;

public class MaxSubStringSum {
    // input
    // abcd
    // adcb
    // 4
    // 1 1
    // 2 2
    // 2 3
    // 3 3

    // output:
    // 7
    // 6
    // 5
    // 2
        // s1,s2的合法子序列a,b，需满足下列条件之一 
        // 1.a为空
        // 2.a[1]<b[1]
        // 寻找所有合法子序列中长度之和的最大值
    public static int SumOfMaxSubStringLength(String s1, String s2) {
        int sum = s2.length();
        for(int i=0;i<s1.length();i++){
            char aStart = s1.charAt(i);
            int lenA = s1.length()-i;
            for(int j=0;j<s2.length();j++){
                char bStart = s2.charAt(j);
                int  lenB = s2.length()-j;
                if(aStart < bStart){
                    sum = Math.max(sum, lenA + lenB);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int ops = in.nextInt();

        while(ops-->0){
            int i = in.nextInt();
            int j = in.nextInt();
            // Convert 1-based indices to 0-based for substring
            System.out.println(SumOfMaxSubStringLength(s1.substring(i - 1), s2.substring(j - 1)));
        }

    }
}
