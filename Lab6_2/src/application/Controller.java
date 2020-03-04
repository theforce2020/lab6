package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	TextField inputText;

	@FXML
	TextField outputText;

	public void countLetters(ActionEvent actionEvent) {
		String word = inputText.getText();
		outputText.setText(String.valueOf(word.length()));
	}

	public void reverseLetters(ActionEvent actionEvent) {
		String word = inputText.getText();
		String reversed = new StringBuilder(word).reverse().toString();
		outputText.setText(reversed);
	}

	public void removeDuplicates(ActionEvent actionEvent) {
		String word = inputText.getText();
		outputText.setText(removeDup(word));
	}

	private String removeDup(String input) {
		String result = "";
	    for (int i = 0; i < input.length(); i++) {
	        if(!result.contains(String.valueOf(input.charAt(i)))) {
	            result += String.valueOf(input.charAt(i));
	        }
	    }
	    return result;
	}
}
