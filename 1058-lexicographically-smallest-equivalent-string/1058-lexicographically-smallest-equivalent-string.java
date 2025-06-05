class Solution {
    
    static class DSU {

        int[] parent;

        public DSU(int n) {
            this.parent = new int[n];
            for (int idx = 0; idx < n; ++idx)
                parent[idx] = idx;
        }

        public int find(int index) {
            if (parent[index] == index)
                return index;
            return parent[index] = find(parent[index]);
        }

        public void union(int idx, int jdx) {

            int parentIdx = find(idx);
            int parentJdx = find(jdx);

            if (parentIdx != parentJdx) {
                if (parentIdx < parentJdx) {
                    parent[parentJdx] = parentIdx;
                } else {
                    parent[parentIdx] = parentJdx;
                }
            }

        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        StringBuilder ans = new StringBuilder();
        DSU dsu = new DSU(26);
        int n = s1.length();
        int m = baseStr.length();

        for (int idx = 0; idx < n; ++idx) {

            int s1idx = s1.charAt(idx) - 'a';
            int s2idx = s2.charAt(idx) - 'a';

            dsu.union(s1idx, s2idx);

        }

        for (int idx = 0; idx < m; ++idx) {

            int charIndex = dsu.find(baseStr.charAt(idx) - 'a');
            char charToAppend = (char) (charIndex + 'a');

            ans.append(charToAppend);
        }

        return ans.toString();

    }

}