package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllApartmentsByTypeView extends GridPane implements View {
	private Controller controller;
	
	private Label allAptsData;
	private Label title;
	private Label type;
	
	private Label firstLabel;
	
	private ToggleGroup group;
	private RadioButton airbnb;
	private RadioButton regular;
	private RadioButton sell;
	
	private HBox hbox;
	
	public AllApartmentsByTypeView(Controller controller) {
		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setBackground(Background.fill(Color.ALICEBLUE));

	}

	public void init() {
		this.hbox = new HBox();

		this.type = new Label("choose type : ");
		
		this.title = new Label();
		this.title.setFont(Font.font(16));
		this.title.setTextFill(Color.BROWN);
		
		this.allAptsData = new Label();
		
		this.firstLabel = new Label("apartment by type: ");
		this.firstLabel.setFont(Font.font(20));
		this.firstLabel.setTextFill(Color.DARKKHAKI);
		
		this.group = new ToggleGroup();
		this.airbnb = new RadioButton("airbnb");
		this.regular = new RadioButton("regular");
		this.sell = new RadioButton("sell");
		
		this.airbnb.setToggleGroup(group);
		this.regular.setToggleGroup(group);
		this.sell.setToggleGroup(group);
		this.setType();
		
	}

	private void setType() {
		airbnb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				title.setText("all airbnb apartments: ");
				allAptsData.setText(controller.allApartmentsByType("AirbnbApartment"));
			}
		});

		regular.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				title.setText("all regular apartments: ");
				allAptsData.setText(controller.allApartmentsByType("RegularApartment"));

			}
		});
		sell.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				title.setText("all sell apartments: ");
				allAptsData.setText(controller.allApartmentsByType("SellApartment"));
			}
		});

	}

	public void addAllComponants() {
		add(firstLabel,0,0);
		add(type, 0, 1);
		add(hbox, 0, 2);
		add(title, 0, 3);
		add(allAptsData, 0, 4);
		
		hbox.getChildren().addAll(airbnb, regular, sell);
		hbox.setSpacing(20);

	}
}
