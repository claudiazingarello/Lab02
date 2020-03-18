package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dictionary;
	

	public AlienDictionary() {
		this.dictionary = new ArrayList<>();
	}

	public void resetDictionary() {
		dictionary.clear();
	}

	/**
	 * Il metodo aggiunge una nuova parola al dizionario con
	 * relativa traduzione se non e' gia' presente al suo interno,
	 * ALTRIMENTI, aggiorna la traduzione
	 * @param alienWord
	 * @param translation
	 */
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		
		if(dictionary.contains(w)) {
			//prendo l'indice della parola ed associo la traduzione
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		dictionary.add(w);
	}
	
	
	/**
	 * il metodo restituisce la traduzione della parola passata da parametro
	 * se gia' presente, restituisce null
	 * @param alienWord
	 * @param translation
	 */
	public String translateWord(String alienWord) {
		Word w = new Word (alienWord);
		
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
	

}
