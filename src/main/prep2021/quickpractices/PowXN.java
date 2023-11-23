package main.prep2021.quickpractices;

public class PowXN {

    private double fastPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = fastPow(x, n/2);
        if (n %2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double actualX = x;
        int actualN = n;
        if (n < 0) {
            actualX = 1.0 / actualX;
            actualN = Math.abs(n);
        }
        return fastPow(actualX, actualN);
    }

    public static void main(String[] args) {
        var solution = new PowXN();
        System.out.println(solution.myPow(2, -5));
    }
}
