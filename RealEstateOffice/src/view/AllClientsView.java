package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllClientsView extends GridPane implements View {

	private Controller controller;

	private Label allClientsData;
	private Label chooseAptLabel;
	private Label sortNames;
	private Label titel;

	private Button sort;
	private Button chooseButton;

	private TextField AptNumber;

	private int index;

	public AllClientsView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setBackground(Background.fill(Color.AZURE));

	}

	public void addAllComponants() {

		add(titel, 0, 0);
		add(chooseAptLabel, 0, 1);
		add(AptNumber, 0, 2);
		add(chooseButton, 1, 2);
		add(sort, 2, 2);

	}

	public void init() {

		this.chooseAptLabel = new Label();
		chooseAptLabel.setText("choose aparmtment number to get all her clients:\n " + "enter number between 1 to "
				+ controller.getAllApartments().size());
		this.chooseAptLabel.setFont(Font.font(14));

		this.titel = new Label("show Clients");
		this.titel.setFont(Font.font(18));
		this.titel.setTextFill(Color.DARKBLUE);

		this.AptNumber = new TextField();

		this.chooseButton = new Button("show clients");
		this.sort = new Button("sort names");
		buttonActions();

	}

	private void buttonActions() {

		chooseButton.setOnAction(e -> {

			if (controller.chooseApartment(index, AptNumber.getText())) {
				index = Integer.parseInt(AptNumber.getText());

				if (sortNames != null) {
					sortNames.setVisible(false);
				}
				if (allClientsData == null) {

					allClientsData = new Label(controller.getClients(index));
					allClientsData.setFont(Font.font(14));

					add(allClientsData, 0, 3);
				} else {
					allClientsData.setVisible(true);
				}
			}
		});

		sort.setOnAction(e -> {
			if (controller.chooseApartment(index, AptNumber.getText())) {
				index = Integer.parseInt(AptNumber.getText());

				if (allClientsData != null) {
					allClientsData.setVisible(false);
				}
				if (sortNames == null) {

					sortNames = new Label(controller.sortClients(index));
					sortNames.setFont(Font.font(14));

					add(sortNames, 0, 3);
				} else {
					sortNames.setVisible(true);
				}

			}

		});

	}
}
