import java.util.Arrays;
public  class  KnightBoard{
 private int[][]board;
 public KnightBoard(int rows,int cols){
   if(rows<=0 || cols<=0){
     throw new IllegalStateException("cols and rows must be greater than 0");
   }
   board=new int[rows][cols];
   for(int row=0;row<board.length;row++){
     for(int  col=0;col<board[row].length;col++){
       board[row][col]=0;
     }
   }
 }
 public boolean solve(int row,int col,int number,int product) {
   if(row<0 || col<0) {
    return false;
  }
  else if(row>=board.length|| col>=board[0].length) {
    return false;
  }
  else if(board[row][col]!=0) {
    return false;
  }
   board[row][col]=number;
   
   if(number==product) {
      return true;
  }		  if(   solve(row+2,col+1,number+1,product)||
         solve(row-2,col+1,number+1,product)||
         solve(row+2,col-1,number+1,product)||
         solve(row+1,col+2,number+1,product)||
         solve(row-1,col+2,number+1,product)||
         solve(row-2,col-1,number+1,product)||
         solve(row+1,col-2,number+1,product)||
         solve(row-1,col-2,number+1,product)) {

                return true;                           }

       board[row][col]=0;
       return false;



}

 public String toString(){
   String result=Arrays.deepToString(board);
   return result;
 }
}
