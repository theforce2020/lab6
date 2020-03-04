package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddressForm extends Application {

	final double rem = Font.getDefault().getSize();
	final String WINDOW_TITLE = "Address Form";
	final String NAME = "Name";
	final String STREET = "Street";
	final String CITY = "City";
	final String STATE = "State";
	final String ZIP = "Zip";
	final String SUBMIT = "Submit";
	final Font labelFont = new Font(12);
	private TextField name;
	private TextField street;
	private TextField city;
	private TextField state;
	private TextField zip;
	private HBox topPanel;
	private HBox middlePanel;
	private HBox bottomPanel;
	private Button submitButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle(WINDOW_TITLE);
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(topPanel, 0, 0);
		grid.add(middlePanel, 0, 1);
		bottomPanel.setPadding(new Insets(35, 0, 0, 0));
		grid.add(bottomPanel, 0, 2);

		submitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				outputToConsole();
				clearFields();
			}
		});
		Scene scene = new Scene(grid, 500, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	protected void outputToConsole() {
		String nameVal = name.getText();
		String streetVal = street.getText();
		String cityVal = city.getText();
		String stateVal = state.getText();
		String zipVal = zip.getText();
		String n = System.getProperty("line.separator");
		String output = nameVal + n + streetVal + n + cityVal + ", " + stateVal
				+ " " + zipVal;
		System.out.println(output);
	}

	private void clearFields() {
		name.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");
	}

	private void defineBottomPanel() {
		submitButton = new Button(SUBMIT);
		bottomPanel = new HBox();
		bottomPanel.setAlignment(Pos.CENTER);
		bottomPanel.getChildren().add(submitButton);

	}

	private void defineMiddlePanel() {

		VBox state = getItem(STATE);
		VBox zip = getItem(ZIP);

		middlePanel = new HBox(rem * 5);
		middlePanel.setAlignment(Pos.CENTER);
		middlePanel.getChildren().addAll(state, zip);

	}

	private void defineTopPanel() {

		VBox name = getItem(NAME);
		VBox street = getItem(STREET);
		VBox city = getItem(CITY);

		topPanel = new HBox(rem * 5);
		topPanel.getChildren().addAll(name, street, city);
	}

	private VBox getItem(String labelName) {
		Label label = new Label(labelName);
		label.setFont(labelFont);

		VBox item = new VBox(0.2 * rem);

		TextField textField = null;
		switch (labelName) {
		case NAME:
			name = new TextField();
			textField = name;
			break;
		case STREET:
			street = new TextField();
			textField = street;
			break;
		case ZIP:
			zip = new TextField();
			textField = zip;
			break;
		case STATE:
			state = new TextField();
			textField = state;
			break;
		case CITY:
			city = new TextField();
			textField = city;
			break;
		default:
			break;
		}

		item.getChildren().addAll(label, textField);
		return item;
	}

	public static void main(String[] args) {
		launch(args);
	}
}