class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int totalCandies = 0;
        var processingQueue = new LinkedList<>();
        var lockedBoxesSet = new HashSet<Integer>();

        for (var initialBox: initialBoxes) {
            if (status[initialBox] == 1)
                processingQueue.offer(initialBox);
            else 
                lockedBoxesSet.add(initialBox);
        }

        while(!processingQueue.isEmpty()) {
            int box = (int)processingQueue.poll();
            totalCandies += candies[box];

            for (int key : keys[box]) {
                status[key] = 1;
                if (lockedBoxesSet.contains(key)) {
                    processingQueue.offer(key);
                    lockedBoxesSet.remove(key);
                }
            }

            for (var containedBox : containedBoxes[box]) {
                if (status[containedBox] > 0)
                    processingQueue.offer(containedBox);
                else 
                    lockedBoxesSet.add(containedBox);
            }
        }

        return totalCandies;

    }

}