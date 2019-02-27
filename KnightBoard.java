


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
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

private int[][] ListMoves(int row,int col){ // method checked and works
	int[][]answer=new int[8][2];
    answer[0][0]=row+2;
    answer[0][1]=col+1;
    answer[1][0]=row+2;
    answer[1][1]=col-1;
    answer[2][0]=row-2;
    answer[2][1]=col+1;
    answer[3][0]=row-2;
    answer[3][1]=col-1;
    answer[4][0]=row+1;
    answer[4][1]=col+2;
    answer[5][0]=row-1;
    answer[5][1]=col+2;
    answer[6][0]=row+1;
    answer[6][1]=col-2;
    answer[7][0]=row-1;
    answer[7][1]=col-2;
    return answer;
}
public int  countMoves(int row,int col) {   // works like a charm, throughly tested
	if(row>=board.length|| col>=board[0].length || row<0 || col<0|| board[row][col]!=0) {
		return -1;
	}
	int count=0;
	int[][]data=ListMoves(row,col);
	for(int i=0;i<data.length;i++) {
		if(data[i][0]>=0 && data[i][1]>=0 && data[i][0]<board.length && data[i][1]<board[0].length
				&& board[data[i][0]] [data[i][1]]==0) {
			count++;
		}
	}
	return count;
}
public int[][]solveSteps(int row,int col){
	 int[][]data=ListMoves(row,col);
	 ArrayList<Integer>Moves=new ArrayList<Integer>();
	 for(int i=0;i<data.length;i++) {
		 if(countMoves(data[i][0],data[i][1])>=0) {
			 Moves.add(countMoves(data[i][0],data[i][1]));
		 }
	 }
	 Collections.sort(Moves);// the data is sorted
	 int[][]realMoves=new int[Moves.size()][2];
	 for(int i=0;i<Moves.size();i++) {
		 for(int j=0;j<data.length;j++) {
			 if(countMoves(data[j][0],data[j][1])==Moves.get(i)) {
				 realMoves[i][0]=data[j][0];
				 realMoves[i][1]=data[j][1];
				 data[j][0]=-1; // changes the row to negative to avoid repitition
				 break;
			 }
		 }
	 }
	 return realMoves;

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
 public boolean solve(int row,int col) {
	 return solve(row,col,1,board.length*board[0].length);
 }
public boolean fastSolve(int row,int col,int number,int product) {

	if(number==product) {
		board[row][col]=number;
		return true;
	}
	board[row][col]=number;
	int[][]data=solveSteps(row,col);
	if (data.length==0) {
		board[row][col]=0;
		return false;
	}

	for(int i=0;i<data.length;i++) {
		//System.out.println(toString());
		if(fastSolve(data[i][0],data[i][1],number+1,product)) {
			return true;
		}
	}
	board[row][col]=0;
	return false;
}
public boolean fastSolve(int row,int col) {
	return fastSolve(row,col,1,board.length*board[0].length);
}

 public String toString(){

   String result="";
   for(int i=0;i<board.length;i++){
     for(int j=0;j<board[0].length;j++){
       if(board[i][j]>=10) {

       result+=board[i][j]+" ";
       }
       else {
    	result+=" "+board[i][j]+" "
    			+ "";
       }
     }
     result+="\n";

   }
   return result;
 }

 public static void main(String[]args) {
  KnightBoard chess=new KnightBoard(92,93);
  System.out.println(chess.fastSolve(0,0));
  System.out.println(chess);

 }
}
