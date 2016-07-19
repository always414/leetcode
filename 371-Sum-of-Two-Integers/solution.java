public class Solution {
    public int getSum(int a, int b) {
        while (a != 0) {
        	int tmp = (a & b) << 1;  // -> 记录进位
        	b = a ^ b; // 记录单位1
        	a = tmp;
        }
         // 当a＝0， 则再无进位
        return b;
    }
}