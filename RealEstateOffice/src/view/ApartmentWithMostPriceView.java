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

public class ApartmentWithMostPriceView extends GridPane implements View {
	private Controller controller;

	private TextField TF_HiringTime;

	private HBox hbox;

	private Button chooseButton;

	private Label messege;
	private Label theApartment;
	private Label title;
	private Label L_HiringTime;

	private int time;

	public ApartmentWithMostPriceView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		showApartment();
		this.setBackground(Background.fill(Color.LIGHTGREY));

	}

	private void showApartment() {
		this.L_HiringTime.setFont(Font.font(14));
		this.hbox.getChildren().addAll(L_HiringTime, TF_HiringTime, chooseButton);
		this.hbox.setSpacing(10);
		add(hbox, 0, 1);

		chooseButton.setOnAction(e -> {
			if (check()) {
				if (controller.ApartmentWithMostPrice(time) != null) {
					theApartment = new Label(
							"the most expensive apartmet is: \n" + controller.ApartmentWithMostPrice(time));
					theApartment.setFont(Font.font(14));

					add(theApartment, 0, 2);
				} else {
					messege = new Label("all apartment you added for sell\n or\n you did not added any apatment ");
					messege.setFont(Font.font(14));

					add(messege, 0, 2);
				}
			}
		});
	}

	private boolean check() {
		try {
			time = Integer.parseInt(TF_HiringTime.getText());
			if (time <= 0) {
				new MessegeView("hiring time must be positive integer!");

			}
			return true;
		} catch (NumberFormatException e) {
			new MessegeView("enter integer!");
			return false;

		}
	}

	@Override
	public void init() {
		this.hbox = new HBox();
		this.TF_HiringTime = new TextField();
		this.chooseButton = new Button("choose");
		this.L_HiringTime = new Label("choose hiring time");
		this.title = new Label("show most expensive apartment");
		this.title.setFont(Font.font(18));
		this.title.setTextFill(Color.DARKCYAN);

	}

	@Override
	public void addAllComponants() {
		add(title, 0, 0);

	}
}
