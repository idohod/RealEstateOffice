package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Office;
import view.ApartmentReadFromFile;
import view.ComboMenuView;
import view.MessegeView;
import javafx.scene.Scene;

public class Main extends Application {

	private void readFromFile(Controller controller) {
		try {
			controller.readAllApartmentFromFile();
			ApartmentReadFromFile readView = new ApartmentReadFromFile(controller);
			Scene s1 = new Scene(readView, 700, 700);
			Stage st = new Stage();
			st.setScene(s1);
			st.show();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			new MessegeView("not apatment yet");
		}

	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Office office = new Office();
			Controller controller = new Controller(office);

			readFromFile(controller);

			ComboMenuView comboView = new ComboMenuView(controller);
			Scene s = new Scene(comboView, 450, 150);
			primaryStage.setScene(s);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}
}
