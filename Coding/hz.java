import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T --> 0){
            int n = in.nextInt();
            Long m = in.nextLong();
            List<Integer> numSet = new ArrayList<>();
            for(int i=0;i<n;i++){
                numSet.add(in.nextInt());
            }
            numSet.sort((x,y)->x-y);
            // 操作m次，使得不在numSet中的最小非负整数尽可能大
            // 操作：选择下标i的元素，并修改其值
            // 1.统计缺失的非负整数个数
            // 2.比较可操作次数m与缺失个数
            // 3.贪心填补缺失的非负整数
            
            
        }
    }
}
