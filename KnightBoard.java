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
 public String toString(){
   String result=Arrays.deepToString(board);
   return result;
 }
}
