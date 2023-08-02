package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CommtionView extends BorderPane implements View{
	
	private Controller controller;
	private Label commsionLabel;
	private Label title;

	public CommtionView(Controller controller) {
		this.controller = controller;
		init();
		addAllComponants();
		setPadding(new Insets(30));
		this.setBackground(Background.fill(Color.LIGHTBLUE));

	}
	
	public void init() {
		
		this.commsionLabel = new Label();
		this.commsionLabel.setText(controller.getAllCommissions(controller.getAllApartments()));
		this.commsionLabel.setFont(Font.font(14));

		this.title= new Label("all coomtions:");
		this.title.setFont(Font.font(16));
		this.title.setTextFill(Color.DARKORANGE);

	
			
	}

	@Override
	public void addAllComponants() {
		setCenter(commsionLabel);
		setTop(title);

	}
}
