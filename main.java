import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static ArrayList<String> members = new ArrayList<String>();
	static int groupSize;
	
	public static void main(String[] args) {
		input();
		randomize();
		printRand();
	}
	
	//get data from user input
	static void input(){
		String last = "";
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Enter group size:");
		groupSize = kbd.nextInt();
		
		System.out.println("Enter group members (enter 'done' when finished):");
		while(!last.equals("done")){
			last = kbd.next();
			if(!last.equals("done")){
				members.add(last);
			}
		}
		
	}

	//randomize members into new arraylist
	static void randomize(){
		ArrayList randomMembers = new ArrayList();
		String tempMember;
		int getRand;
		int memberSize = members.size();
		
		while (memberSize > 0){
			getRand = (int) (Math.random()*memberSize);
			tempMember = (String) members.get(getRand);
			randomMembers.add(tempMember);
			members.remove(getRand);
			memberSize--;
		}
		members = randomMembers;
	}
	
	static void printRand(){
		int group = 1;
		int memberSize = members.size();
		
		System.out.println("\nGroup 1");
		for(int i = 0; i < memberSize; i++){
			
			System.out.println(members.get(i));
			
			//if we reach the max size of a group then start the next group
			if(((i+1) % groupSize) == 0){ 
				//if we don't have an even amount, keep adding to last group
				if(i+1 != memberSize && (i+2) != memberSize){
					group++;
					System.out.println("\nGroup " + group); //Only print group when we are not adding the last members
				}
				
			}
			
		}
	}
}
