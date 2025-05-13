import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][] {
                { 1, 1, 1},
                { 1, 1, 0},
                { 1, 0, 1},
        };

        image = floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(image));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private static void helper(int[][] image, int sr, int sc, int color, int srcColor) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length) {
            return;
        }
        if (image[sr][sc] != srcColor) {
            return;
        }
        image[sr][sc] = color;
        helper(image, sr + 1, sc, color, srcColor);
        helper(image, sr - 1, sc, color, srcColor);
        helper(image, sr, sc + 1, color, srcColor);
        helper(image, sr, sc - 1, color, srcColor);

    }
}
