package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AddClientView extends GridPane implements View{
	private Controller controller;

	private Button addButton;
	private Button chosenApt;

	private Label choseAptLabel;
	private Label nameLabel;
	private Label phoneLabel;
	private Label labelTitle;

	private TextField textFieldName;
	private TextField textFieldPhone;
	private TextField textFieldAptNumber;
	private int index;

	public AddClientView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setBackground(Background.fill(Color.LIGHTSTEELBLUE));

	}

	public void addAllComponants() {

		add(labelTitle, 0, 0);
		add(choseAptLabel, 0, 1);
		add(textFieldAptNumber, 0, 2);
		add(chosenApt, 1, 2);

		chosenApt.setOnAction(e -> {
			
			if (controller.chooseApartment(index, textFieldAptNumber.getText())) {
				index = Integer.parseInt(textFieldAptNumber.getText());
				addClient();
			}
		});
	}

	private void addClient() {
		nameLabel.setFont(Font.font(14));
		phoneLabel.setFont(Font.font(14));

		add(nameLabel, 0, 3);
		add(phoneLabel, 0, 5);

		add(textFieldName, 0, 4);
		add(textFieldPhone, 0, 6);
		add(addButton, 1, 6);

		addButton.setOnAction(e -> check());

	}

	private void check() {
		String name = textFieldName.getText();
		String phone = textFieldPhone.getText();

		if (controller.chooseApartment(index, textFieldAptNumber.getText())) {
			index = Integer.parseInt(textFieldAptNumber.getText());

			if (controller.getApartmentFromInputIndex(index)
					.addClient(controller.getApartmentFromInputIndex(index).allClientData(name, phone))) {
				new MessegeView("the client added successfully!");
			} else
				new MessegeView("client alredy exists!");
		} else
			return;
	}

	public void init() {

		this.nameLabel = new Label("enter name: ");
		this.phoneLabel = new Label("enter phone: ");
		
		this.choseAptLabel = new Label();
		choseAptLabel.setText("choose apartment number between 1 to " + controller.getAllApartments().size());
		choseAptLabel.setFont(Font.font(14));

		this.labelTitle = new Label("add Client");
		labelTitle.setFont(Font.font(18));
		labelTitle.setTextFill(Color.BLUE);

		this.textFieldName = new TextField();
		this.textFieldPhone = new TextField();
		this.textFieldAptNumber = new TextField();

		this.addButton = new Button("add");
		this.chosenApt = new Button("choose");
		
		
	}



}
