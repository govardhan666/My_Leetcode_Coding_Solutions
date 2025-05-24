class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            if(words[i].contains(Character.toString(x))){
                arr.add(i);
            }
        }
        return arr;
    }
}