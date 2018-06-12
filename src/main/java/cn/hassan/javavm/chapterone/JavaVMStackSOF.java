package cn.hassan.javavm.chapterone;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/5 22:26
 * Description: java 虚拟机栈和本地方法栈溢出
 * VM args -> -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length ---> " + sof.stackLength);
            throw e;
        }

    }
}
