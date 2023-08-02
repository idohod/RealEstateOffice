package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ApartmentReadFromFile extends BorderPane implements View {

		
	private Controller controller;
	private Label allAptsData;
	private Label title;

	public ApartmentReadFromFile(Controller controller) {
		this.controller = controller;
		init();
		addAllComponants();
		setPadding(new Insets(10));
		this.setBackground(Background.fill(Color.BLANCHEDALMOND));


	}

	public void init() {

		this.title = new Label("all apartments read from file : ");
		this.title.setFont(Font.font(20));
		this.title.setTextFill(Color.BROWN);
		
		this.allAptsData = new Label(controller.toString());
		this.allAptsData.setFont(Font.font(14));


	}

	@Override
	public void addAllComponants() {
		setTop(title);
		setCenter(allAptsData);

		
	}

}
