## 语法八股
- 类
    public class Car{...}
- 对象
    Car myCar = new Car();
- extends 继承
    public class ElectricCar extends Car{...}
- implements 实现接口
    public class ElectricCar implements Vehicle{...}
- 方法
    public void drive(){...}
- 多态
    - 方法重载,同一个类中可以有多个同名的方法，但参数不同。
        public int add(int a, int b){}
        public double add(double a, double b){}
    - 方法重写
        @Override 
        public void drive(){
            System.out.println("Electric car is driving");
        }
- 内置数据类型： byte, short, int, long, float, double, char(只占2个字节), boolean
- 常量 final double PI = 3.1415926;

- 所有整型包装类对象之间值的比较，全部使用 equals 方法比较。
    Integer a = 128;
    Integer b = 128;
    System.out.println(a == b); // false
    System.out.println(a.equals(b)); // true

    Integer c = new Integer(128);
    System.out.println(a == c); // false
    System.out.println(a.equals(c)); // true

    Integer i1 = 33;
    Integer i2 = 33;
    System.out.println(i1 == i2);// 输出 true

    Float i11 = 333f;
    Float i22 = 333f;
    System.out.println(i11 == i22);// 输出 false

    Double i3 = 1.2;
    Double i4 = 1.2;
    System.out.println(i3 == i4);// 输出 false

- 装箱拆箱
    Integer a = 10; // 装箱
    int b = a; // 拆箱
    装箱其实就是调用了包装类的valueOf()方法，拆箱其实就是调用了xxxValue()方法。
    如果频繁拆装箱的话，也会严重影响系统的性能。我们应该尽量避免不必要的拆装箱操作

- 浮点数精度丢失：计算机用2进制存数据
```java
    BigDecimal a = new BigDecimal("0.1");
    BigDecimal b = new BigDecimal("0.2");
    System.out.println(a.add(b)); // 0.3
    System.out.println(a.subtract(b)); // -0.1
    
    BigDecimal a = new BigDecimal("1.0");
    BigDecimal b = new BigDecimal("1.00");
    BigDecimal c = new BigDecimal("0.8");

    BigDecimal x = a.subtract(c);
    BigDecimal y = b.subtract(c);

    System.out.println(x); /* 0.2 */
    System.out.println(y); /* 0.20 */
    // 比较内容，不是比较值
    System.out.println(Objects.equals(x, y)); /* false */
    // 比较值相等用相等compareTo，相等返回0
    System.out.println(0 == x.compareTo(y)); /* true */
```
- 成员变量 v.s. 局部变量
    - 成员变量：类中定义，在方法外定义的变量，属于对象属性，可以被类中所有方法访问。
    - 局部变量：在方法内定义的变量，只能在方法内使用，出了方法就不能访问了。
    - 成员变量有默认值，局部变量没有默认值，必须初始化后才能使用。
    - 成员变量存储在堆内存中，局部变量存储在栈内存中。
    - 成员变量可以被 public,private,static 等修饰符所修饰，而局部变量不能被访问控制修饰符及 static 所修饰
    - 成员变量和局部变量都能被 final 所修饰

- 接口 interface
    - 接口中所有的方法都是 public abstract 的，可以省略不写
    - 接口中所有的成员变量都是 public static final 的，可以省略不写
    - 一个类可以实现多个接口，用逗号分隔
    - 接口可以继承多个接口，用逗号分隔
    - Java 8 之后，接口中可以有默认方法和静态方法
    - 默认方法使用 default 关键字修饰，静态方法使用 static 关键字修饰
    - 接口不能被实例化，可以通过实现类来实例化对象
    - 接口中的默认方法可以被实现类重写
    - 接口中的静态方法不能被实现类重写，只能通过接口名调用
    - 接口中的静态方法不能被继承，只能通过接口名调用

- Java异常类
    - Throwable
        - Error：一般是指系统级别的错误，程序无法处理，比如内存溢出，栈溢出等
        - Exception：程序本身可以处理的异常
            - 受检异常（Checked Exception）：编译时异常，必须处理，比如 IOException, SQLException 等
            - 非受检异常（Unchecked Exception）：运行时异常，程序可以选择处理，比如 NullPointerException, ArrayIndexOutOfBoundsException 等
    - try-catch-finally
    ```java
    try {
        // 可能会抛出异常的代码
    } catch (ExceptionType1 e1) {
        // 处理异常类型1
    } catch (ExceptionType2 e2) {
        // 处理异常类型2
    } finally {
        // 无论是否发生异常，都会执行的代码
    }
    ```