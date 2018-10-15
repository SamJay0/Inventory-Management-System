package javaapplication18;
import java.util.Scanner;
/**
 * @author SamJay
 */
public class JavaApplication18 {
   
    public static void main(String[] args) {
       Scanner Mercy=new Scanner(System.in);
       System.out.println("Enter a");
int a=Mercy.nextInt();
 System.out.println("Enter b");
int b=Mercy.nextInt();

 Mercy.close();
 System.out.print("a+b="); 
int c=a+b;

int d=a*b;
int e=a/b;
System.out.println(c);
System.out.print("a*b=");
System.out.println(d);
System.out.print("a/b=");
System.out.println(e);
    }

}
