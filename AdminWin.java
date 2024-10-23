package pages;


import javafx.scene.layout.BorderPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;


public class AdminWin extends BorderPane{
	
	 public AdminWin(Stage primaryStage) {
try {
	BorderPane root = new BorderPane();
    root.setStyle("-fx-background-color: #A0522D;");
    MenuBar menuBar = new MenuBar();
    Menu menu = new Menu("Menu");
    MenuItem logoutItem = new MenuItem("Logout");
    menu.getItems().add(logoutItem);
    menuBar.getMenus().add(menu);

    Label adminText = new Label("ADMIN PAGE");
    adminText.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-text-weight: bold;");

    VBox contentBox = new VBox();
    contentBox.setPadding(new Insets(10));
    contentBox.setMaxWidth(800);
    contentBox.setSpacing(10);
    contentBox.setStyle("-fx-background-color: #A0522D;");
    contentBox.setAlignment(Pos.CENTER);

    HBox charmBox1 = createCharmBox("Heart", "assets/image/heart.png", 5, 10, "Adds an additional hit point but lightly weakens your attack power");
    HBox charmBox2 = createCharmBox("Coffee", "assets/image/coffee.png", 8, 7, "Super meter continuously fills in addition to what you earn");
    HBox charmBox3 = createCharmBox("Whetstone", "assets/image/w.png", 6, 6, "Sharpens your attacks for increased damage");

    contentBox.getChildren().addAll(charmBox1, charmBox2, charmBox3);

    VBox mainContentBox = new VBox();
    mainContentBox.setPadding(new Insets(40));
    mainContentBox.setSpacing(20);
    mainContentBox.setAlignment(Pos.TOP_CENTER);
    mainContentBox.getChildren().addAll(adminText, contentBox);

    StackPane centerPane = new StackPane(mainContentBox);
    centerPane.setAlignment(Pos.TOP_CENTER);
    centerPane.setPadding(new Insets(20));

    logoutItem.setOnAction(e -> {
        primaryStage.close();
    });

    root.setTop(menuBar);
    root.setCenter(centerPane);

    Scene scene = new Scene(root, 800, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Admin Page");
    primaryStage.setFullScreen(true);
    primaryStage.show();
	} catch (Exception e) {
    e.printStackTrace();
		}
	 }


private HBox createCharmBox(String name, String imagePath, double price, int stock, String description) {
HBox charmBox = new HBox();
charmBox.setPadding(new Insets(10));
charmBox.setSpacing(10);
charmBox.setStyle("-fx-background-color: #8B4513; -fx-border-color: #A0522D; -fx-border-width: 2;");
charmBox.setPrefWidth(800);

VBox imageBox = new VBox();
imageBox.setAlignment(Pos.CENTER);
imageBox.setSpacing(10);
imageBox.setPrefWidth(300);
imageBox.setPrefHeight(900);

ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
imageView.setFitWidth(100);
imageView.setFitHeight(120);
imageView.setOnMouseClicked(e -> {
});

Label nameLabel = new Label(name);
nameLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");
nameLabel.setPrefWidth(100);

imageBox.getChildren().addAll(nameLabel,imageView);

VBox detailsBox = new VBox();
detailsBox.setSpacing(10);
detailsBox.setAlignment(Pos.CENTER_LEFT);
detailsBox.setPrefWidth(650);

HBox priceStockBox = new HBox();
priceStockBox.setSpacing(10);
priceStockBox.setAlignment(Pos.CENTER_LEFT);

Label priceLabel = new Label("Price:");
priceLabel.setStyle("-fx-text-fill: white;");
TextField priceField = new TextField(String.valueOf(price));
priceField.setPrefWidth(80);

Label stockLabel = new Label("Stock:");
stockLabel.setStyle("-fx-text-fill: white;");
Spinner<Integer> stockSpinner = new Spinner<>(1, 100, stock);

priceStockBox.getChildren().addAll(priceLabel, priceField, stockLabel, stockSpinner);

VBox descriptionBox = new VBox();
descriptionBox.setSpacing(5);
Label descriptionLabel = new Label("Description:");
descriptionLabel.setStyle("-fx-text-fill: white;");
TextArea descriptionArea = new TextArea(description);
descriptionArea.setWrapText(true);
descriptionArea.setPrefWidth(600);
descriptionArea.setPrefHeight(60);

descriptionBox.getChildren().addAll(descriptionLabel, descriptionArea);

Button updateButton = new Button("Update");
updateButton.setStyle("-fx-background-color: #683404; -fx-text-fill: white;");
updateButton.setPrefWidth(100);
updateButton.setOnAction(e -> {
    try {
        double newPrice = Double.parseDouble(priceField.getText());
        int newStock = stockSpinner.getValue();
        String newDescription = descriptionArea.getText();

        if (newPrice <= 0 || newStock <= 0 || newDescription.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Price and stock must be more than 0, and description must be filled in.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Charm information updated successfully.");
        }
    } catch (NumberFormatException ex) {
        showAlert(Alert.AlertType.ERROR, "Validation Error", "Price must be numeric and more than 0.");
    }
});

detailsBox.getChildren().addAll(priceStockBox, descriptionBox, updateButton);
charmBox.getChildren().addAll(imageBox, detailsBox);

return charmBox;
}

private void showAlert(Alert.AlertType alertType, String title, String content) {
Alert alert = new Alert(alertType);
alert.setTitle(title);
alert.setContentText(content);
alert.showAndWait();
}
}
