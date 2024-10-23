package pages;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import java.lang.Math;


public class ViewCharm {
	 BorderPane root;
	    StackPane imageContainer;
	    Button scaleInc;
	    Button scaleDec;
	    Button rotateInc;
	    Button rotateDec;
	    
	    Label title;
	    Label descriptionLine1;
	    Label descriptionLine2;

	    double rotationCount = 0;
	    double scaleCount = 1;

	    public ViewCharm() {
	        root = new BorderPane();

	        // Buttons
	        scaleInc = new Button("+");
	        scaleDec = new Button("-");
	        rotateInc = new Button("<-");
	        rotateDec = new Button("->");

	        HBox buttonContainer = new HBox(10);
	        buttonContainer.getChildren().addAll( scaleInc, scaleDec, rotateInc, rotateDec);
	        buttonContainer.setAlignment(Pos.CENTER);
	        
	        // Load Font
	        Font alegreyaFont = loadFont("aset/AlegreyaSansSC-Bold.ttf", 20);
	       
	        
	        // Title
	        title = new Label("HEART");
	        title.setTextFill(Color.WHITE);
	        title.setFont(alegreyaFont);
	        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

	        // Descriptions
	        descriptionLine1 = new Label("ADDS AN ADDITIONAL HIT POINT BUT LIGHTLY");
	        descriptionLine2 = new Label("WEAKENS YOUR ATTACK POWER");
	        descriptionLine1.setTextFill(Color.WHITE);
	        descriptionLine2.setTextFill(Color.WHITE);
	        descriptionLine1.setFont(alegreyaFont);
	        descriptionLine2.setFont(alegreyaFont);

	        // Image
	        ImageView image = loadImage("aset/heart.png");
	        image.setFitWidth(100);
	        image.setPreserveRatio(true);

	        imageContainer = new StackPane(image);
	        imageContainer.setPrefSize(200, 200); // Setting a preferred size
	        imageContainer.setAlignment(Pos.CENTER);
	        
	        scaleInc.setOnMouseClicked(e -> scaleImage(image, 0.1));
	        scaleDec.setOnMouseClicked(e -> scaleImage(image, -0.1));
	        rotateInc.setOnMouseClicked(e -> rotateImage(image, 15));
	        rotateDec.setOnMouseClicked(e -> rotateImage(image, -15));
	        
	        VBox descriptionContainer = new VBox(5);
	        descriptionContainer.getChildren().addAll(descriptionLine1, descriptionLine2);
	        descriptionContainer.setAlignment(Pos.CENTER);

	        VBox topContainer = new VBox(10);
	        topContainer.getChildren().addAll(title, imageContainer, descriptionContainer, buttonContainer);
	        topContainer.setAlignment(Pos.CENTER);
	        

	        root.setCenter(topContainer);
	        root.setStyle("-fx-background-color: #BF6900;");
	        
	    }

	    private void rotateImage(ImageView image, double degree) {
	        rotationCount += degree;
	        Rotate rotation = new Rotate(rotationCount, image.getFitWidth() / 2, image.getFitHeight() / 2);
	        image.getTransforms().clear();
	        image.getTransforms().add(rotation);
	    }

	    private void scaleImage(ImageView image, double num) {
	        scaleCount += num;
	        scaleCount = Math.min(Math.max(scaleCount, 0.75), 1.5);
	        Scale scale = new Scale(scaleCount, scaleCount, image.getFitWidth() / 2, image.getFitHeight() / 2);
	        image.getTransforms().clear();
	        image.getTransforms().add(scale);
	    }

	    public void setScene(Stage stage) {
	        Scene scene = new Scene(root, 800, 600);
	        stage.setScene(scene);
	        stage.setTitle("View Charm Window");
	        stage.show();
	    }

	    private ImageView loadImage(String url) {
	        File file = new File(url);
	        return new ImageView(file.toURI().toString());
	    }

	    private Font loadFont(String path, double size) {
	        try {
	            File file = new File(path);
	            return Font.loadFont(file.toURI().toString(), size);
	        } catch (Exception e) {
	            System.err.println("Font not loaded.");
	            return Font.getDefault();
	        }
	    }
}
