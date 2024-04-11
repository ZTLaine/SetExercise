package main;

import java.util.*;


public class SetExerciseApplication {
	
	// instatiate new hashset
	static Set<String> pokerHands = new HashSet<>();

	public static void main(String[] args) {

		// extract the data from the CSV
		FileService file = new FileService();
		pokerHands = file.populateSet(pokerHands);
		printHands();
		System.out.println("~~~");
		
		// remove ACE HIGH and QUEEN HIGH
        pokerHands.removeIf(hand -> hand.equalsIgnoreCase("ACE HIGH") || hand.equalsIgnoreCase("QUEEN HIGH"));
		printHands();
		System.out.println("~~~");
		
		// Update PAIR to DEUCES
		Iterator<String> iterator = pokerHands.iterator();
		List<String> updatedHands = new ArrayList<>();
		while(iterator.hasNext()) {
			String hand = iterator.next();
			String[] tempHand = hand.split(" ");
			boolean updated = false;

			for(int i = 0; i < tempHand.length ; i++) {
				if (tempHand[i].toUpperCase().contains("PAIR")) {
					tempHand[i] = "DEUCES";
					updated = true;
				}
				if(updated) {
					iterator.remove();
					updatedHands.add(String.join(" ", tempHand));
				}
			}
		}
        pokerHands.addAll(updatedHands);
		printHands();
		
	}
	
	public static void printHands() {
		for(String hand : pokerHands){
			System.out.println(hand);
		}
	}



}
