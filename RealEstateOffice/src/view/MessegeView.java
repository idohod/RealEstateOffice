package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MessegeView extends StackPane{
	
	public MessegeView(String str){
		
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		showMessege(str);
		this.setBackground(Background.fill(Color.MOCCASIN));

	}
	
	private void showMessege(String str) {
		
		Stage stage1 = new Stage();
		Label l = new Label(str);
		l.setFont(Font.font(14.5));
		this.getChildren().addAll(l);
		stage1.setScene(new Scene(this, 350, 200));
		
		stage1.show();
		
		
	}
	
	
	
	
	
	
}
