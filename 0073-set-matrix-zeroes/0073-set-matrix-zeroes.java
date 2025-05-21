class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> res=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    res.add(new Pair(i,j));
                }
            }
        }
         int row=matrix.length;
    int col=matrix[0].length;
    for(int l=0;l<res.size();l++){
        Pair p=res.get(l);
        int ridx=p.row;
        for(int j=0;j<col;j++){
            matrix[ridx][j]=0;
        }
        int cidx=p.col;
        for(int i=0;i<row;i++){
            matrix[i][cidx]=0;
        }
    }
    }
   
    
}