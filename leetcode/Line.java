package leetcode;

public class Line {
    public static void main(String[] args) {
        int[][] coordinates = { { -3, -2 }, { -1, -2 }, { 2, -2 }, { -2, -2 }, { 0, -2 } };
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        double denom = (coordinates[1][0] - coordinates[0][0]);
        if (denom == 0) {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[i-1][0]) return false;
            }
            return true;
        }
        double slope = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        double constant = coordinates[1][1] - (slope * coordinates[1][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double val = coordinates[i][1] - slope * coordinates[i][0] - constant;
            if (val != 0)
                return false;
        }
        return true;
    }
}