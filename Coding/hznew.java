import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hznew {
    public static int findMes(List<Integer> numSet, int n, Long m) {
        numSet.sort((x,y)->x-y);
        // 操作m次，使得不在numSet中的最小非负整数尽可能大
        // 操作：选择下标i的元素，并修改其值
        // 超时，m>>n时，直接返回n+m.intValue()
        if(m > n){
            return n + m.intValue();
        }
        int mes = 0;
        for(int i=0;i<n;i++){
            if(numSet.get(i) == mes){
                mes++;
            } else if(numSet.get(i) > mes){
                if(m > 0){
                    mes++;
                    m--;
                    i--; // 重新检查当前元素
                } else {
                    break;
                }
            }
        }
        return mes;
    }
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

            System.out.println(findMes(numSet, n, m));
        }
    }
}