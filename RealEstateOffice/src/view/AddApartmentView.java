package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AddApartmentView extends GridPane implements View {
	private Controller controller;

	private int type;

	private Label labelTitle;
	private Label labelAdress;
	private Label labelArea;
	private Label labelNumOfRooms;
	private Label LabelBorkerRate;
	private Label LabelHiringTime;
	private Label labelPrice;
	private Label labelType;

	private HBox hbox;

	private ToggleGroup group;
	private RadioButton airbnb;
	private RadioButton regular;
	private RadioButton sell;

	private Button buttonEnter;

	private TextField textFieldAdress;
	private TextField textFieldArea;
	private TextField textFieldNumOfRooms;
	private TextField textFieldBorkerRate;
	private TextField textFieldPrice;
	private TextField textFieldHiringTime;

	public AddApartmentView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setBackground(Background.fill(Color.LIGHTSKYBLUE));

	}

	private void check() {
		int hiringTime = 0, numOfRooms = 0, borkerRate = 0;
		String address = "";
		double area = 0, price = 0;

		try {
			address = textFieldAdress.getText();
			area = Double.parseDouble(textFieldArea.getText());
			numOfRooms = Integer.parseInt(textFieldNumOfRooms.getText());
			borkerRate = Integer.parseInt(textFieldBorkerRate.getText());
			price = Double.parseDouble(textFieldPrice.getText());
			if (textFieldHiringTime.isVisible()) {
				hiringTime = Integer.parseInt(textFieldHiringTime.getText());
			} else {
				hiringTime = 0;
			}

		} catch (NumberFormatException e) {
			new MessegeView("worng input!");
			return;
		}

		if (textFieldHiringTime.getText().equals(""))
			hiringTime = 0;

		if (controller.allApartmentData(type, address, area, numOfRooms, borkerRate, hiringTime, price) == null)
			return;

		if (controller.addApartment(
				controller.allApartmentData(type, address, area, numOfRooms, borkerRate, hiringTime, price))) {

			new MessegeView("the aparmtment added successfully");
		} else
			new MessegeView("aparmtment alredy exists - same address");
	}

	public void addAllComponants() {

		addAllLabels();
		addAllTextField();
		setAlignment(Pos.CENTER);

		hbox.getChildren().addAll(airbnb, regular, sell);
		hbox.setSpacing(20);
		add(hbox, 0, 2);

		add(buttonEnter, 5, 8);
		sell.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				textFieldHiringTime.setVisible(false);
				LabelHiringTime.setVisible(false);
				type = 3;
			}
		});
		regular.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				textFieldHiringTime.setVisible(true);
				LabelHiringTime.setVisible(true);
				type = 2;

			}
		});
		airbnb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				textFieldHiringTime.setVisible(true);
				LabelHiringTime.setVisible(true);
				type = 1;
			}
		});

	}

	private void addAllTextField() {

		add(textFieldAdress, 1, 3);
		add(textFieldArea, 1, 4);
		add(textFieldNumOfRooms, 1, 5);
		add(textFieldBorkerRate, 1, 6);
		add(textFieldHiringTime, 1, 7);
		add(textFieldPrice, 1, 8);
	}

	private void addAllLabels() {
		labelTitle.setFont(Font.font(20));
		labelTitle.setTextFill(Color.GREEN);

		add(labelTitle, 0, 0);
		add(labelType, 0, 1);

		add(labelAdress, 0, 3);
		add(labelArea, 0, 4);
		add(labelNumOfRooms, 0, 5);
		add(LabelBorkerRate, 0, 6);
		add(LabelHiringTime, 0, 7);
		add(labelPrice, 0, 8);
	}

	public void init() {
		this.type = 1;
		this.hbox = new HBox();

		initGroup();
		initLabels();

		initTextFields();

		this.buttonEnter = new Button("add");

		buttonEnter.setOnAction(e -> {
			check();

		});

	}

	private void initGroup() {

		this.group = new ToggleGroup();
		this.airbnb = new RadioButton("airbnb");
		this.regular = new RadioButton("regular");
		this.sell = new RadioButton("sell");

		this.airbnb.setFont(Font.font(14));
		this.regular.setFont(Font.font(14));
		this.sell.setFont(Font.font(14));

		this.airbnb.setToggleGroup(group);
		this.regular.setToggleGroup(group);
		this.sell.setToggleGroup(group);
		this.airbnb.setSelected(true);
	}

	private void initTextFields() {
		this.textFieldAdress = new TextField();
		this.textFieldArea = new TextField();
		this.textFieldNumOfRooms = new TextField();
		this.textFieldBorkerRate = new TextField();
		this.textFieldPrice = new TextField();
		this.textFieldHiringTime = new TextField();
	}

	private void initLabels() {

		this.labelTitle = new Label("add apartment ");
		this.labelAdress = new Label("Adress:");
		this.labelArea = new Label("Area: (must be positive number)");
		this.labelNumOfRooms = new Label("Num Of Rooms: (must be positive integer)");
		this.LabelBorkerRate = new Label("Borke Rate: (must be integer between 0 to 10");
		this.labelPrice = new Label("Price: (must be positive number)");
		this.LabelHiringTime = new Label("hirnigTime: (must be positive integer) ");
		this.labelType = new Label("choose type");

		Label[] allLebLabels = { labelAdress, labelArea, labelNumOfRooms, LabelBorkerRate, labelPrice, LabelHiringTime,
				labelType };
		for (Label l : allLebLabels) {
			l.setFont(Font.font(14));
		}

	}

}
