package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllApartmentsView extends GridPane implements View {
	private Controller controller;
	private Label allAptsData;
	private Label title;

	public AllApartmentsView(Controller controller) {
		this.controller = controller;
		init();
		addAllComponants();
		setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setBackground(Background.fill(Color.ANTIQUEWHITE));


	}

	public void init() {

		this.title = new Label("all apartments: ");
		this.title.setFont(Font.font(20));
		this.title.setTextFill(Color.BROWN);

		this.allAptsData = new Label(controller.toString());
		this.allAptsData.setFont(Font.font(14));

	}

	@Override
	public void addAllComponants() {
		add(title, 0, 0);
		add(allAptsData, 0, 1);

	}

}
