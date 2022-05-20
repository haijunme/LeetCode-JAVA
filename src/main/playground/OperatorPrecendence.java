package main.playground;

public class OperatorPrecendence {
    private int test = 0;

    private static boolean testOne() {
        System.out.println("1");
        return true;
    }

    private static boolean testTwo() {
        System.out.println("2");
        return false;
    }

    private static boolean testThree() {
        System.out.println("3");
        return true;
    }


    public static void main(String[] args) {
        var instance = new OperatorPrecendence();
        System.out.println(instance.test);
        System.out.println(1 << 13);
    }
}
