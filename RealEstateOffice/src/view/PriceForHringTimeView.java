package view;

import controller.Controller;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PriceForHringTimeView extends GridPane implements View {

	private Controller controller;

	private Label choseAptLabel;
	private Label choseTimeLabel;
	private Label price;
	private Label title;

	private HBox hBox1;
	private HBox hBox2;

	private TextField textFieldAptNumber;
	private TextField textFieldhiringTime;

	private Button chosenApt;
	private Button showPrice;

	private int index = 0, time = 1;

	public PriceForHringTimeView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setBackground(Background.fill(Color.MINTCREAM));

	}

	public void init() {

		title = new Label("show price for hring time");
		title.setFont(Font.font(18));
		title.setTextFill(Color.CHOCOLATE);

		choseTimeLabel = new Label("choose time");

		this.choseAptLabel = new Label();
		choseAptLabel.setText("choose apartment number between 1 to " + controller.getAllApartments().size());

		textFieldAptNumber = new TextField();
		textFieldhiringTime = new TextField();

		showPrice = new Button("show");
		chosenApt = new Button("choose");

		hBox1 = new HBox();
		hBox1.getChildren().addAll(choseAptLabel, textFieldAptNumber, chosenApt);
		hBox1.setSpacing(10);

		chosenApt.setOnAction(e -> check());

	}

	public void addAllComponants() {

		add(title, 0, 0);
		add(hBox1, 0, 1);

	}

	private void check() {

		if (controller.chooseApartment(index, textFieldAptNumber.getText())) {
			index = Integer.parseInt(textFieldAptNumber.getText());

			hBox2 = new HBox();
			hBox2.getChildren().addAll(choseTimeLabel, textFieldhiringTime, showPrice);
			hBox2.setSpacing(10);

			add(hBox2, 0, 2);

			showPrice.setOnAction(e -> {
				try {
					time = Integer.parseInt(textFieldhiringTime.getText());
					if (time <= 0) {
						new MessegeView("hiring time must be positive integer");

					} else {
						price = new Label(controller.getPriceForHringTime(index, time));
						add(price, 0, 3);
					}
				} catch (NumberFormatException e1) {
					new MessegeView(e1.getMessage());
					return;
				}

			});

		}
	}

}
