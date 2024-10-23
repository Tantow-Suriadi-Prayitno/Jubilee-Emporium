package pages;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShopWin extends BorderPane {
    
    private Label lblTitle;
    private ListView<String> cartListView;
    private ObservableList<String> cartItems;
    private Label totalLabel;
    private Button checkoutButton, clearCartButton;
    
    private void initComp() {
        lblTitle = new Label("Shop Window");
        cartItems = FXCollections.observableArrayList();
        cartListView = new ListView<>(cartItems);
        totalLabel = new Label("Total: 0");
        checkoutButton = new Button("Checkout");
        clearCartButton = new Button("Clear Cart");
    }
    
    private void addComp() {
        // Top - Title
        HBox topBox = new HBox(lblTitle);
        topBox.setAlignment(Pos.CENTER);
        setTop(topBox);
        
        // Center - Shop Items
        GridPane shopItemsPane = new GridPane();
        shopItemsPane.setHgap(10);
        shopItemsPane.setVgap(10);
        shopItemsPane.setPadding(new Insets(10, 10, 10, 10));

        // Add shop items
        addShopItem(shopItemsPane, "Heart", new File("assets/image/heart.png").toURI().toString(), 0, 0);
        addShopItem(shopItemsPane, "Coffee", new File("assets/image/coffee.png").toURI().toString(), 1, 0);
        addShopItem(shopItemsPane, "Whetstone", new File("assets/image/whetstone.png").toURI().toString(), 0, 1);
        addShopItem(shopItemsPane, "Twin Heart", new File("assets/image/twinheart.png").toURI().toString(), 1, 1);
        
        setCenter(shopItemsPane);
        
        // Right - Cart
        VBox cartBox = new VBox(10, new Label("Your Cart"), cartListView, totalLabel, checkoutButton, clearCartButton);
        cartBox.setPadding(new Insets(10));
        cartBox.setAlignment(Pos.TOP_CENTER);
        setRight(cartBox);
    }
    
    private void addShopItem(GridPane pane, String name, String imagePath, int col, int row) {
        VBox itemBox = new VBox(5);
        itemBox.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Label nameLabel = new Label(name);
        Label priceLabel = new Label("Price: 5");
        Button addButton = new Button("Add to Cart");

        addButton.setOnAction(e -> addToCart(name, 5));

        itemBox.getChildren().addAll(imageView, nameLabel, priceLabel, addButton);
        pane.add(itemBox, col, row);
    }
    
    private void addToCart(String itemName, int price) {
        cartItems.add(itemName + " - $5");
        updateTotal();
    }
    
    private void updateTotal() {
        int total = cartItems.size() * 5; // Assuming all items are $5
        totalLabel.setText("Total: $" + total);
    }
    
    public ShopWin() {
        initComp();
        addComp();
    }
}
