public class SpreadsheetToNumber {
    public static void main(String[] args) {
        System.out.println(convertColumnToNumber("ZZ"));
        System.out.println(convertNumberToColumns(702));
    }

    private static String convertNumberToColumns(int input) {
        StringBuilder res = new StringBuilder();
//        input;
        while (input > 0) {
            int remainder = input % 26;
//            System.out.println(remainder);
            if (remainder == 0) {
                res.append('Z');
                input--;
            } else {
                res.append((char) ('A' - 1 + remainder));
            }
            input /= 26;
        }
        return res.reverse().toString();
    }

    private static String convertColumnToNumber(String column) {
        final int base = 26;
        final int diff = 1 - 'A';
        long result = 0;
        column = column.toUpperCase();
        for (int i = 0; i < column.length(); i++) {
            result = result * base + column.charAt(i) + diff;
        }
        return result + "";
    }
}
