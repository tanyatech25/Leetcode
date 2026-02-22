import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int i = 1;    
        int j = 0;    

        while (i <= n && j < target.length) {
            ops.add("Push");

            if (target[j] == i) {
                j++;           
            } else {
                ops.add("Pop"); 
            }
            i++;
        }
        return ops;
    }
}