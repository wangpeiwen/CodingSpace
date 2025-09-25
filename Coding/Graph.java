public interface Graph {
    default void defaultMethod(){
        System.out.println("Successfully set the edge!");
    };
    public void setEdge(int n);
    public int getEdge();
    public double getAria();
}