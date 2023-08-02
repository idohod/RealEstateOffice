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

public class CloneAptView extends GridPane implements View {

	private Controller controller;

	private Label choseAptLabel;
	private Label cloneApt;
	private Label title;

	private Button choose;
	private TextField chooseApt;
	private HBox hbox;

	private int index = 0;

	public CloneAptView(Controller controller) {

		this.controller = controller;
		init();
		addAllComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
		this.setBackground(Background.fill(Color.IVORY));

	}

	public void init() {
		this.hbox = new HBox();

		this.title = new Label("clone aprtment");
		this.title.setFont(Font.font(18));
		this.title.setTextFill(Color.DARKSALMON);

		this.choseAptLabel = new Label();
		this.choseAptLabel.setText("choose apartment number between 1 to " + controller.getAllApartments().size());
		this.choseAptLabel.setFont(Font.font(14));

		this.cloneApt = new Label();
		this.choose = new Button("choose");
		this.chooseApt = new TextField();
	}

	@Override
	public void addAllComponants() {

		add(title, 0, 0);

		hbox.getChildren().addAll(choseAptLabel, chooseApt, choose);
		add(hbox, 0, 1);
		hbox.setSpacing(10);

		choose.setOnAction(e -> {

			if (controller.chooseApartment(index, chooseApt.getText())) {
				index = Integer.parseInt(chooseApt.getText());
				try {
					cloneApt.setText(controller.dublicateApt(index));
					cloneApt.setFont(Font.font(14));
					add(cloneApt, 0, 2);

				} catch (CloneNotSupportedException e1) {
					new MessegeView(e1.getMessage());
				}
			}

		});
	}

}
