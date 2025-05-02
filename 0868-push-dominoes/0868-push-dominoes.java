class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        // Convert to array for in-place modification
        char[] ch = dominoes.toCharArray();
        int i = 0;
        
        // Traverse through the array
        while (i < n) {
            // Skip non-dot characters
            if (ch[i] != '.') {
                i++;
                continue;
            }
            
            // Find the end of this segment of dots
            int j = i;
            while (j < n && ch[j] == '.') {
                j++;
            }
            
            // Determine what's on the left and right of the segment
            boolean hasLeft = (i - 1 >= 0);
            boolean hasRight = (j < n);
            
            // Case 1: Both sides exist
            if (hasLeft && hasRight) {
                char left = ch[i - 1];
                char right = ch[j];
                
                if (left == right) {
                    // e.g., 'R...R' or 'L...L' — fill entire segment
                    for (int k = i; k < j; k++) {
                        ch[k] = left;
                    }
                } else if (left == 'R' && right == 'L') {
                    // e.g., 'R...L' — fill inwards
                    int u = i, v = j - 1;
                    while (u < v) {
                        ch[u++] = 'R';
                        ch[v--] = 'L';
                    }
                    // middle stays '.' if there's an odd count
                }
            }
            // Case 2: Only left side exists
            else if (hasLeft) {
                if (ch[i - 1] == 'R') {
                    // e.g., 'R...' — all become 'R'
                    for (int k = i; k < j; k++) {
                        ch[k] = 'R';
                    }
                }
            }
            // Case 3: Only right side exists
            else if (hasRight) {
                if (ch[j] == 'L') {
                    // e.g., '...L' — all become 'L'
                    for (int k = i; k < j; k++) {
                        ch[k] = 'L';
                    }
                }
            }
            
            // Move i to the end of the processed segment
            i = j;
        }
        
        // Convert back to string and return
        return new String(ch);
    }
}