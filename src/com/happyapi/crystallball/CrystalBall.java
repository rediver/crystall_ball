package com.happyapi.crystallball;

import java.util.Random;

public class CrystalBall {

	
	// Member wariables 
	
    public String[] mAnswers = {  
			/* zainicjowana tablica strin o zmienny answers */
		
			"tak super",
			"tak fajnie",
		    "zajebiscie",
			
			"nie",
			"nie chujowo",
			"nie ma mowy",
			
			"moze ",
			"zobaczymy",
			"mejbi bejbi"
	};
	
	// Metody 
	
	public String getAnAnswer() {
	
		// TODO 
		
		String answer = "";
//		losowe wybieranie yes,no or meybe
		
		Random randomGenerator = new Random();   //konstruktor random zaczyna sie tutaj
		int randomNumber = randomGenerator.nextInt(mAnswers.length); //metoda nextInt losuje licze z zakresu w nawiasie
		/*answer = Integer.toString(randomNumber);*/
	 /*
	    * Implementacja - convert randomNumber to a text answer 
	    * 0 - Yes 
	    * 1 - No 
	    * 2 - Maybe
    */
	     										 // if randomnumer is 0
		
												 // 	wczyttywanie wrunkowe
												
										         /*	if(randomNumber == 0) {
														 // output yes
														answer = "Yes";
													}
												 // if 1
													else if(randomNumber == 1) {
														 // output no
														answer = "No";
													}
												 // if 2 
													else if(randomNumber == 2) {
														 // output maybe
														answer = "Maybe";
													}	
													else {
														answer = "sorry error";
												}*/
	
		// WCZYTAWYWANIE Z MIACIERZY ODPOWIEDZI 
		
		answer = mAnswers[randomNumber];
		return answer;
	}
	
}
