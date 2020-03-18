package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FXMLController {
	
	AlienDictionary dictionary = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnTranslate;

    @FXML
    private ImageView imgAlen;

    @FXML
    private TextArea txtDizionario;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtDizionario.clear();
    	dictionary.resetDictionary();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtDizionario.clear();
    	
    	String campoTesto = txtParola.getText().toLowerCase(); //trasformo tutto in minuscolo
    	
    	//Controllo sull' input
    	if(campoTesto == null || campoTesto.length() == 0) {
    		txtDizionario.setText("Devi inserire 1 o 2 parole!");
    		return ;
    	}
    	
    	StringTokenizer st = new StringTokenizer(campoTesto, " ");
    	
    	//Ulteriore controllo sull'input (non strettamente necessario)
    	if (!st.hasMoreTokens()) {
    		txtDizionario.setText("Devi inserire 1 o 2 parole!");
    		return;
    	}
    	
    	//Estraggo la prima parola
    	String alienWord = st.nextToken();
    	 
    	//Se non ci sono ulteriori parole, fornisco la traduzione
    	if(!st.hasMoreTokens()) {
    		
    		//Controllo che non ci siano caratteri non ammessi
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtDizionario.setText("Inserire solo caratteri alfabetici!");
    			return ;
    		}
    		
    		String traduzione = dictionary.translateWord(alienWord);
    		
    		if (traduzione != null)
    			txtDizionario.setText("Traduzione: " + traduzione);
    		else
    			txtDizionario.setText("La parola cercata non esiste nel dizionario");
    	}
    	
    	String traduzione = st.nextToken();
    	//Controllo che non ci siano caratteri non ammessi
		if(!alienWord.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
			txtDizionario.setText("Inserire solo caratteri alfabetici!");
			return ;
		}
    	
		//Aggiungo la parola aliena nel dizionario con relativa traduzione
    	dictionary.addWord(alienWord, traduzione);
    	txtDizionario.setText("La parola "+alienWord +" con traduzione " + traduzione + " e' stata aggiunta al dizionario");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert imgAlen != null : "fx:id=\"imgAlen\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
