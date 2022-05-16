package main.quickpractices.graph.bfsdfs;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int currentFuel = 0;
        int startingPosition = 0;
        for (int i = 0; i < gas.length; i ++) {
            totalFuel += gas[i] - cost[i];
            currentFuel += gas[i] - cost[i];
            if (currentFuel < 0) {
                startingPosition = i + 1;
                currentFuel = 0;
            }
        }
        if (totalFuel < 0) {
            return -1;
        }
        return startingPosition;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = new int[]{4};
        int[] cost = new int[]{5};
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }
}
