package pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class InventoryWindow {
	 private BorderPane root;
	    private List <Charm> charms;
	    private VBox inventoryContainer;
	    //private Font customFont;

	    public InventoryWindow() {
	        root = new BorderPane();
	        
	        //customFont = Font.loadFont("aset/AlgreyaSansSC-Bold.ttf", 20);
	        
	        //menubar
	        Menu fileMenu = new Menu("Menu");
			
			fileMenu.getItems().add(new MenuItem("Shop"));
			fileMenu.getItems().add(new MenuItem("Logout"));
			
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu);

	        // Initialize charms
	        charms = new ArrayList<>();
	        charms.add(new Charm("HEART", "assets/image/heart.png", 2));
	        charms.add(new Charm("COFFEE", "assets/image/coffee.png", 2));
	        charms.add(new Charm("WHETSTONE", "assets/image/whetstone.png", 2));
	        charms.add(new Charm("TWIN HEART", "assets/image/twinheart.png", 1));
	        charms.add(new Charm("SMOKE BOMB", "assets/image/smokebomb.png", 3));

	        // Header

	        Label inventoryLabel = new Label("JE'S Inventory");
	        inventoryLabel.setStyle("-fx-font-size: 23px; -fx-font-weight: bold;-fx-text-fill: white;");
	        //inventoryLabel.setFont(customFont);
	        inventoryLabel.setAlignment(Pos.CENTER);

	        VBox headerContainer = new VBox(10);
	        headerContainer.getChildren().addAll (inventoryLabel);
	        headerContainer.setAlignment(Pos.CENTER);

	        // Inventory container
	        inventoryContainer = new VBox(20);
	        inventoryContainer.setAlignment(Pos.CENTER);

	        // Add charms to inventory display
	        updateInventoryDisplay();
	        
	        VBox topContainer = new VBox(menuBar, headerContainer);
	        root.setTop(topContainer);
	        root.setCenter(inventoryContainer);
	        root.setStyle("-fx-background-color: #683404;");
	    }

	    private void updateInventoryDisplay() {
	        inventoryContainer.getChildren().clear();
	        
	        HBox firstRow = new HBox(20);
	        firstRow.setAlignment(Pos.CENTER);
	        if (charms.size() > 0) firstRow.getChildren().add(createCharmBox(charms.get(0)));
	        if (charms.size() > 1) firstRow.getChildren().add(createCharmBox(charms.get(1)));
	        if (charms.size() > 2) firstRow.getChildren().add(createCharmBox(charms.get(2)));

	        HBox secondRow = new HBox(20);
	        secondRow.setAlignment(Pos.CENTER);
	        if (charms.size() > 3) secondRow.getChildren().add(createCharmBox(charms.get(3)));
	        if (charms.size() > 4) secondRow.getChildren().add(createCharmBox(charms.get(4)));
	        
	        inventoryContainer.getChildren().addAll(firstRow, secondRow);
	    }

	    private HBox createCharmBox(Charm charm) {
	        Label nameLabel = new Label(charm.getName());
	        nameLabel.setStyle("-fx-text-fill: white;");
	        //nameLabel.setFont(customFont);
	        nameLabel.setPrefHeight(10);
	        
	        ImageView imageView = loadImage(charm.getImagePath());
	        imageView.setFitHeight(120);
	        imageView.setFitWidth(100);
	        
	        Label quantityLabel = new Label("QUANTITY: " + charm.getQuantity());
	        quantityLabel.setStyle(("-fx-text-fill: white;"));
	        //quantityLabel.setFont(customFont);
	        quantityLabel.setPrefHeight(10);
	        
	        Button useButton = new Button("USE CHARM");
	        useButton.setStyle("-fx-background-color: #683404; -fx-text-fill: white;");
	        useButton.setPrefHeight(10);
	        //useButton.setFont(customFont);
	        
	        useButton.setOnAction(e -> {
	            if (charm.getQuantity() > 1) {
	                charm.setQuantity(charm.getQuantity() - 1);
	            } else {
	                charms.remove(charm);
	            }
	            updateInventoryDisplay();
	        });

	        VBox charmDetails = new VBox(10);
	        charmDetails.getChildren().addAll(nameLabel, imageView, quantityLabel, useButton);
	        charmDetails.setAlignment(Pos.CENTER);

	        HBox charmBox = new HBox(10);
	        charmBox.getChildren().add(charmDetails);
	        charmBox.setPadding(new Insets(10));
	        charmBox.setSpacing(10);
	        charmBox.setPrefWidth(160);
	        charmBox.setAlignment(Pos.CENTER);
	        charmBox.setStyle("-fx-padding: 10; -fx-background-color: #8B4513; -fx-border-width: 2px;-fx-background-radius: 15; -fx-border-radius: 15;");

	        return charmBox;
	    }

	    private ImageView loadImage(String url) {
	        File file = new File(url);
	        ImageView imageView = new ImageView(file.toURI().toString());
	        imageView.setFitWidth(90);
	        imageView.setFitHeight(100);
	        imageView.setPreserveRatio(true);
	        return imageView;
	    }

	    public void setScene(Stage stage) {
	        Scene scene = new Scene(root, 1000, 600);
	        stage.setScene(scene);
	        stage.setTitle("Jubilee Emporium");
	        stage.show();
	    }
}
