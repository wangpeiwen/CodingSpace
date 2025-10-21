package LEETCODE.JAVA;

import java.util.Scanner;

public class rs {
    // 修复IPV4地址
    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false; // 前导零
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
    // public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // // 注意 hasNext 和 hasNextLine 的区别
        // String s = in.nextLine();
        // StringBuilder sb = new StringBuilder();
        // // ‘.’丢失，按升序返回所有可能的IPV4地址
        // // 思路：枚举三个点的位置，分割字符串，判断每个部分是否合法
        // int n = s.length();
        // for (int i = 1; i < Math.min(n, 4); i++) {
        //     for (int j = i + 1; j < Math.min(n, i + 4); j++) {
        //         for (int k = j + 1; k < Math.min(n, j + 4); k++) {
        //             String part1 = s.substring(0, i);
        //             String part2 = s.substring(i, j);
        //             String part3 = s.substring(j, k);
        //             String part4 = s.substring(k);
        //             if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
        //                 // System.out.println(part1 + "." + part2 + "." + part3 + "." + part4);
        //                 sb.append(part1).append(".").append(part2).append(".").append(part3).append(".").append(part4).append("\n");
        //             }
        //         }
        //     }
        // }
        // System.out.print(sb.toString());
        
    // }

    // 找到最繁忙的服务台
    // 服务台分配规则：
    // 1. 按照客户编号%服务台数量分配e.g. 客户0分配服务台0，客户1分配服务台1，客户2分配服务台2，客户3分配服务台0，依次类推
    // 2. 如果服务台忙，则访问下一个服务台，直到找到空闲服务台，如果最后一个服务台也忙，则从第一个服务台开始继续查找
    // 3. 如果所有服务台都忙，则该客户放弃服务

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int counters = in.nextInt();
        int clients = in.nextInt();

        int[] arriveTime = new int[clients];
        int[] serveTime = new int[clients];

        for(int i=0;i<clients;i++){
            arriveTime[i] = in.nextInt();
        }

        for(int i=0;i<clients;i++){
            serveTime[i] = in.nextInt();
        }

        // 处理到达时间和服务时间
        int[] endTime = new int[counters]; // 每个服务台的结束时间
        int[] serveCount = new int[counters]; // 每个服务台的服务次数

        for(int i=0;i<clients;i++){
            int arrival = arriveTime[i];
            int service = serveTime[i];
            int index = i % counters; // 初始分配的服务台

            boolean served = false;
            for(int j=0;j<counters;j++){
                int currIndex = (index + j) % counters;
                if(endTime[currIndex] <= arrival){ // 服务台空闲
                    endTime[currIndex] = arrival + service; // 更新结束时间
                    serveCount[currIndex]++; // 增加服务次数
                    served = true;
                    break;
                }
            }
            // 如果所有服务台都忙，该客户放弃服务
            if(!served){
                continue;
            }
        }

        // 找到服务次数最多的服务台
        
    }
}
