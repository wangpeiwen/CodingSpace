// 图形 包含方法 get变长 计算面积
// 圆、长方形、正方形 对应的实现
public class Circle implements Graph {
    private int len;
    @Override
    public void defaultMethod() {
        Graph.super.defaultMethod();
    }

    @Override
    public void setEdge(int n) {
        this.len = n;        
    }

    @Override
    public int getEdge() {
        return len;
    }

    @Override
    public double getAria() {
        return Math.PI * len * len;
    }

    public static void main(String[] args){
        Circle yuan = new Circle();
        yuan.setEdge(6);
        yuan.defaultMethod();
        double s = yuan.getAria();
        System.out.println(s);
    }
}

