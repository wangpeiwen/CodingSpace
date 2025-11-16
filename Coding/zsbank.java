public class zsbank {
    public static void main(String[] args) {
        System.out.println("Welcome to ZS Bank!");
        // 1. 数字按照12345678910...的顺序存放，10将作为两位数存放，输入一个数字n，输出第n个数字是多少
        int n = 316; // 示例输入
        System.out.println("The " + n + "th digit is: " + findNthDigit(n));
    }

    public static int findNthDigit(int n) {
        int k = 1;
        // 位数
        int count = 1;
        // n=13

        // 第一步：确定第n个数字所在的位数
        while (n > 9 * k * count) {
            n -= 9 * k * count; // 减去当前位数的所有数字所占的总位数
            count *= 10; // 进入下一位数（如从1位到10位，即2位数）
            k += 1; // 位数计数加1（1位、2位、3位...）
        }

        // 第二步：确定第n个数字所在的具体数字
        int number = count + (n - 1) / k; // 计算目标数字

        // 第三步：确定该数字中对应的具体位置
        int index = (n - 1) % k; // 计算目标数字中的索引位置

        int divisor = 1;
        for(int i=0;i<k-1-index;i++){
            divisor *= 10;
        }

        return (number / divisor) % 10;
    }
}
