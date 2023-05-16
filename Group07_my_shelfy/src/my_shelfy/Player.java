package my_shelfy;

public class Player 
{
	 private int points ;	
	 public static int  COUNTER;
	 //private Bookshelf shelf;
	 //private Personalgoal personal;
	 
	 public Player() {
		 if(COUNTER<4) {
			 COUNTER++;
		 }
		 	this.points=0;
	 }
	 
	 public void setPoint(int point) {
		this.points=point; 
	 }
	 
	 public int getPoint() {
		 return this.points;
	 }
	/*  public void incrementaPunti() {
		  int point=this.points
		// point=personal.getpoint;;
				  this.points=
		  
	  }*/
	 
}
