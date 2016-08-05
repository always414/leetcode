import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        //mirror management
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
        	int highBit = 1 << i;
        	
        	int size = res.size();
        	for (int j = size - 1; j >= 0; j--) {
        		res.add(res.get(j) + highBit);
        	}
        }
        
        return res;
    }
}