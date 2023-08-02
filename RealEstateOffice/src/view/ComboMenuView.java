package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ComboMenuView extends BorderPane implements View {

	private Controller controller;
	private Label title;
	private ComboBox<String> comboMenu;

	public ComboMenuView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();

		setPadding(new Insets(50));
		this.setBackground(Background.fill(Color.SEASHELL));
	}

	public void init() {

		this.title = new Label("choose from menu:");
		this.title.setFont(Font.font(16));
		this.title.setTextFill(Color.RED);

		this.comboMenu = new ComboBox<>();

		comboMenu.getItems().addAll(controller.helpPrint().split("\n"));

		comboMenu.setOnAction(e -> {
			char c = comboMenu.getValue().charAt(0);
			controller.goToSelectedView(c, controller);

		});

	}

	@Override
	public void addAllComponants() {
		setTop(title);
		setCenter(comboMenu);

	}

}