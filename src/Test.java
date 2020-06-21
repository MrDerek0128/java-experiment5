import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double[][] d1 = { {1,2,3},{4,5,6},{7,8,9},{10,11,12} } ;
        double[][] d2 = { {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15} } ;
        double[][] d3 = { {1,2},{3,4} } ;
        Matrix m1 = new Matrix(d1);
        Matrix m2 = new Matrix(d2);
        Matrix m3 = new Matrix(d3);
        System.out.println("m1");
        m1.toStringv();
        System.out.println("m2");
        m2.toStringv();
        System.out.println("m3");
        m3.toStringv();
        while (true) {
            System.out.println("1.m1与m2相乘");
            System.out.println("2.m1与m3相乘");
            System.out.println("3.m1数据查询");
            System.out.println("4.m1数据修改");
            System.out.println("5.m1数据输出");
            Scanner c = new Scanner(System.in);
            int choice = c.nextInt();
            if (choice == 1) {
                m1.multiply(m2).toStringv();
            }
            else if (choice == 2) {
                try {
                    m1.multiply(m3).toStringv();
                }catch (NullPointerException e) {
                    e.toString();
                }
            }
            else if (choice == 3) {
                System.out.println("请输入查询的行或列");
                Scanner input = new Scanner(System.in);
                System.out.println(m1.getData(input.nextInt(),input.nextInt()));
            }
            else if (choice == 4) {
                System.out.println("请输入修改的行列及数值");
                Scanner input1 = new Scanner(System.in);
                m1.setData(input1.nextInt(), input1.nextInt(), input1.nextInt());
            }
            else if (choice == 5){
                m1.toStringv();
            }
        }
    }
}
