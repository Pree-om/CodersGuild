import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left=0;
        int mlen = 0;
        for(int right = 0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            mlen = Math.max(mlen, right-left+1);
        }
        return mlen;
    }
}
