class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            
            // Pop while top is safe (≤ smallest remaining)
            while (!stack.isEmpty() && stack.peek() <= getMinChar(freq)) {
                result.append(stack.pop());
            }
        }
        
        // Append any remaining characters
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    private char getMinChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char)('a' + i);
            }
        }
        return 'z'; // When no characters left
    }
}