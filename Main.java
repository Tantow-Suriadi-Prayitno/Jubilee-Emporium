package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pages.LoginPage;
import pages.ShopWin;

public class Main extends Application {
	
	private Scene sc;
	private Image imgLogo;
	private ImageView ivLogo;
	
	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) throws Exception {
		
		sc = new Scene(new ShopWin(), 1100, 700);
		imgLogo = new Image(new File("assets/image/applogo.png").toURI().toString());
		ivLogo = new ImageView(imgLogo);
		primaryStage.setScene(sc);
		primaryStage.setTitle("Jubilee Emporium");
		primaryStage.show();  
		
	}

}
