class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();   
            int freq = entry.getValue();  

            int groupSize = answer + 1;

            int numberOfGroups = (freq + groupSize - 1) / groupSize;

            totalRabbits += numberOfGroups * groupSize;
        }

        return totalRabbits;
    }
}