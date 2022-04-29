package main.playground;

public class OperatorPrecendence {

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
        if (testOne() || testTwo() && testThree()) {
            System.out.println("haha");
        }
    }
}
