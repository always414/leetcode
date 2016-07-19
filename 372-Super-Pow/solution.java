public class Solution {
    public int superPow(int a, int[] b) {
        int B = Integer.parseInt(String.valueOf(b).toString());
        return (int) Math.pow(a, B);
    }
}