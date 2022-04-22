package main.quickpractices.dynamicprogramming;

public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int max = 0;
        for (int parts = 2; parts < n; parts ++) {
            int basic = n/parts;
            int extraOnes = n%parts;
            int product = (int)Math.pow(basic+1, extraOnes) * (int)Math.pow(basic, parts-extraOnes);
            if (parts > 2 && product < max) {
                break;
            }
            max = product;
        }
        return max;
    }

    public static void main(String[] args) {
        var solution = new IntegerBreak();
        System.out.println(solution.integerBreak(10));
    }
}
