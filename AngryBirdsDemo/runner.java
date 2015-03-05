
import java.util.Scanner;

public class runner {
	public static void main(String args[]) {
		
		int x, y;
		
		Scanner key = new Scanner(System.in);
		scene run = new scene();
		
		while (true){
			
			System.out.println("X velocity:");
			x= key.nextInt();
			System.out.println("Y velocity:");
			y= key.nextInt();
			
			
			run.setVelocity(x,y);
			run.animate();
			
		}
		
		
	}
}