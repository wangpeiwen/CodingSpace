import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example {
    // 定义一个字符型常量
    public static final char LETTER_A = 'A';

    // 定义一个字符串常量
    public static final String GREETING_MESSAGE = "Hello, world!";

    public int add(int a, int b) {
        return a + b;
    }


   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            switch (a){
                case 1:
                    int insert = in.nextInt();
                    list.add(insert);
                    break;
                case 2:
                    list.remove(list.get(list.size()-1));
                    break;
                case 3:
                    int find = in.nextInt();
                    if(find < list.size()-1){
                        System.out.println(list.get(find));
                    }
                    break;
                case 4:
                // 输入格式为 `4 i x`，表示在下标为 i 的元素与下标为 i+1 的元素之间插入整数 x
                    int pos = in.nextInt();
                    int num = in.nextInt();
                    list.add(pos, num);
                    break;
                case 5:
                // 升序
                    list.sort((x, y) -> x - y);
                    break;
                case 6:
                    // 降序
                    list.sort((x, y) -> y - x);
                    break;
            }
        }
    }
} 