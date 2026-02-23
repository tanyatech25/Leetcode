import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;            
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == need) return true; 
        }
        return seen.size() == need;
    }
}