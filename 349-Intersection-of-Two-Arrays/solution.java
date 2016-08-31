public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        
        int[] res = new int[list.size()];
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < res.length; i++) {
            res[i] = itr.next();
        }
        
        return res;
    }
}