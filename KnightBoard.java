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
 private boolean solveH(int row,int col,int moveNumber) {
 System.out.println(moveNumber);
   System.out.println("this is row:"+ row + "this is col:" + col);

   if(row<0 || col<0) {
    return false;
  }
  else if(row>=board.length || col>=board[0].length) {
    return false;
  }
  else if(moveNumber==board.length* board[0].length) {
   // System.out.println("this is row:"+ row + "this is col:" + col);
    board[row][col]=moveNumber;;
    System.out.println(board.length* board[0].length);
    return true;
  }
  board[row][col]=moveNumber;
  if(solveH(row+2,col+1,moveNumber+1)||
   solveH(row-2,col+1,moveNumber+1)||
   solveH(row+2,col-1,moveNumber+1)||
   solveH(row+1,col+2,moveNumber+1)||
   solveH(row-1,col+2,moveNumber+1)||
   solveH(row-2,col-1,moveNumber+1)||
   solveH(row+1,col-2,moveNumber+1)||
   solveH(row-1,col-2,moveNumber+1)) {

   return true;
  }
  return false;
}
 public String toString(){
   String result=Arrays.deepToString(board);
   return result;
 }
}
