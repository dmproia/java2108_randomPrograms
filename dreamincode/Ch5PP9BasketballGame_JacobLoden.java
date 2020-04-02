package dreamincode;
import java.util.Scanner;

public class Ch5PP9BasketballGame_JacobLoden {
	private String nameA;
	private String nameB;
	private int scoreA = 0;
	private int scoreB = 0;
	private boolean gameOver;
		public void setGameOver(){
			gameOver = false;
		}	
		public void setNameA(String newNameA){
			nameA = newNameA;
		}
		public void setNameB(String newNameB){
			nameB = newNameB;
		}
		public void setScoreA(int newScoreA){
			if ((newScoreA< 1) || (newScoreA> 3)){
				System.out.println("You entered an invalid score.");
				System.exit(0);
			}
			else if ((scoreA + newScoreA) > 100){
					gameOver = true;
					System.out.println("Game out.");
			}
			else{
				scoreA = scoreA + newScoreA;
			}
		}
		public void setScoreB(int newScoreB){
			if ((newScoreB < 1) || (newScoreB > 3)){
				System.out.println("You entered an invalid score.");
				System.exit(0);
			}
			else if ((scoreB + newScoreB) > 100){
					gameOver = true;
					System.out.println("Game over.");
			}
			else{
				scoreB = scoreB + newScoreB;
			}
		}	
		public void readImput(){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter first team's name.");
			nameA = keyboard.next();
			System.out.println("Enter the other team's name.");
			nameB = keyboard.next();
			while (gameOver == false){
				System.out.println("Enter point scored by " + nameA);
				scoreA = keyboard.nextInt();
				System.out.println("Enter point scored by " + nameB);
				scoreB = keyboard.nextInt();
			}
			System.out.println("Game Over.");
		}
}

