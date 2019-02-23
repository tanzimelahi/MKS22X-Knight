
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public  class  KnightBoard{
 public int[][]board;

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

 public int countMoves(int row,int col) {
	 if(row>=board.length|| col>=board[0].length|| row<0|| col<0) {
		 return -1;
	 }
	 int count=0;
	 if(row+2<board.length && col+1<board[0].length &&row+2>=0 && col+1>=0 && board[row+2][col+1]==0) {
		 count++;
	 }
	 if(row-2<board.length && col+1<board[0].length && row-2>=0 && col+1>=0 && board[row-2][col+1]==0) {
		 count++;
	 }
	 if(row+2<board.length && col-1<board[0].length &&row+2>=0 && col-1>=0 && board[row+2][col-1]==0) {
		 count++;
	 }
	 if(row-2<board.length && col-1<board[0].length &&row-2>=0 && col-1>=0 && board[row-2][col-1]==0) {
		 count++;
	 }
	 if(row+1<board.length && col+2<board[0].length &&row+1>=0 && col+2>=0 && board[row+1][col+2]==0) {
		 count++;
	 }
	 if(row-1<board.length && col+2<board[0].length &&row-1>=0 && col+2>=0 && board[row-1][col+2]==0) {
		 count++;
	 }
	 if(row+1<board.length && col-2<board[0].length &&row+1>=0 && col-2>=0 && board[row+1][col-2]==0) {
		 count++;
	 }
	 if(row-1<board.length && col-2<board[0].length &&row-1>=0 && col-2>=0 && board[row-1][col-2]==0) {
		 count++;
	 }
	 return count;
 }
 public int[][] superCountMoves(int row,int col) {
	 ArrayList<Integer> data= new ArrayList<Integer>();
	 if(row+2<board.length && col+1<board[0].length &&row+2>=0 && col+1>=0 && board[row+2][col+1]==0) {
		data.add( countMoves(row+2,col+1));
	 }
	 if(row-2<board.length && col+1<board[0].length && row-2>=0 && col+1>=0 && board[row-2][col+1]==0) {
		data.add(countMoves(row-2,col+1));
	 }
	 if(row+2<board.length && col-1<board[0].length &&row+2>=0 && col-1>=0 && board[row+2][col-1]==0) {

			data.add( countMoves(row+2,col-1));
	 }
	 if(row-2<board.length && col-1<board[0].length &&row-2>=0 && col-1>=0 && board[row-2][col-1]==0) {

		data.add( countMoves(row-2,col-1));
	 }
	 if(row+1<board.length && col+2<board[0].length &&row+1>=0 && col+2>=0 && board[row+1][col+2]==0) {

		 data.add(countMoves(row+1,col+2));

	 }
	 if(row-1<board.length && col+2<board[0].length &&row-1>=0 && col+2>=0 && board[row-1][col+2]==0) {

		data.add( countMoves(row-1,col+2));
	 }
	 if(row+1<board.length && col-2<board[0].length &&row+1>=0 && col-2>=0 && board[row+1][col-2]==0) {

		 data.add(countMoves(row+1,col-2));

	 }
	 if(row-1<board.length && col-2<board[0].length &&row-1>=0 && col-2>=0 && board[row-1][col-2]==0) {
		data.add( countMoves(row-1,col-2));

	 }
	 Collections.sort(data);
	 int[][]coords=new int[data.size()][2];
	 boolean first,second,third,fourth,fifth,sixth,seventh,eight;
	 first=true;
	 second=true;
	 third=true;
	 fourth=true;
	 fifth=true;
	 sixth=true;
	 seventh=true;
	 eight=true;

	 for(int i=0;i<data.size();i++) {
		 if(countMoves(row+2,col+1)==data.get(i)&& first) {
			 coords[i][0]=row+2;
			 coords[i][1]=col+1;
			 first=false;

		 }
		 else if(countMoves(row+2,col-1)==data.get(i)&&second) {
			 coords[i][0]=row+2;
			 coords[i][1]=col-1;
			 second=false;
		 }
		 else if(countMoves(row-2,col+1)==data.get(i)&&third) {
			 coords[i][0]=row-2;
			 coords[i][1]=col+1;
			 third=false;
		 }
		 else if(countMoves(row-2,col-1)==data.get(i)&&fourth) {
			 coords[i][0]=row-2;
			 coords[i][1]=col-1;
			 fourth=false;
		 }
		 else if(countMoves(row+1,col+2)==data.get(i)&&fifth) {
			 coords[i][0]=row+1;
			 coords[i][1]=col+2;
			 fifth=false;
		 }
		 else if(countMoves(row+1,col-2)==data.get(i)&&sixth) {
			 coords[i][0]=row+1;
			 coords[i][1]=col-2;
			 sixth=false;
		 }
		 else if(countMoves(row-1,col+2)==data.get(i)&&seventh) {
			 coords[i][0]=row-1;
			 coords[i][1]=col+2;
			 seventh=false;
		 }
		 else if(countMoves(row-1,col-2)==data.get(i)&&eight) {
			 coords[i][0]=row-1;
			 coords[i][1]=col-2;
			 eight=false;

		 }
	 }
	 System.out.println(data);

	 return coords;

 }
 public boolean solve(int startingRow, int startingCol) {
	 if(startingRow<0 || startingRow>=board.length || startingCol<0 || startingCol>=board[0].length) {
		 throw new IllegalArgumentException("correct your arguments");
	 }
	 return fastSolve(startingRow,startingCol,1,board.length*board[0].length);
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
	  System.out.println("row:"+row+"col: "+col+"num: "+number+Arrays.deepToString(board));
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
 public boolean fastSolve(int row,int col,int number,int product){
	 System.out.println(product);
		  if(row<0 || col<0) {
			 return false;
		 }
		 else if(row>=board.length|| col>=board[0].length) {
			 return false;
		 }
		 else if(board[row][col]!=0) {
			 if(board[row][col]<0) {
				 throw new IllegalStateException();
			 }
			 return false;
		 }
		  board[row][col]=number;
		  System.out.println("row:"+row+"col: "+col+"num: "+number+Arrays.deepToString(board));
		  if(number==product) {
				 return true;
		 }
		  int[][]data=superCountMoves(row,col);
		  for(int i=0;i<data.length;i++) {
			  if(fastSolve(data[i][0],data[i][1],number+1,product)) {
				  return true;
			  }
		  }

	board[row][col]=0;
	return false;
 }


 public static void main(String[]args) {
	 KnightBoard test=new KnightBoard(5,6);
	 KnightBoard test2=new KnightBoard(3,4);
	System.out.println(test.fastSolve(2,2,1,30

			));





 }
}
