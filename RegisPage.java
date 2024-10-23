package pages;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RegisPage extends StackPane {
	
	private Button btnregister;
	private Label lblLogin,lblpass,lblusername,lblnama,lblconfirm;
	private TextField txtuser,txtname;
	private PasswordField txtpass,txtconfirm;
	private ImageView iv,iv2;
	private Image img,img2;
	private VBox vb,vb2;
	private int count = 0;
	
	
	
	private void initComp()
	{
		btnregister = new Button("Register");
		lblLogin = new Label("Login Here");
		lblpass = new Label("Password");
		lblusername = new Label("Email");
		lblnama = new Label("Name");
		lblconfirm = new Label("Confirm Password");
		txtuser = new TextField();
		txtname = new TextField();
		txtpass = new PasswordField();
		txtconfirm = new PasswordField();
		
		img = new Image(new File("assets/image/logo.png").toURI().toString());
		iv = new ImageView(img);
		
		img2 = new Image(new File("assets/image/register bg.jpg").toURI().toString());
		iv2 = new ImageView(img2);
		
		vb = new VBox();
		vb2 = new VBox();
		
	}
	
	private void addComp()
	{
		
		lblusername.setTextFill(Color.WHITE);
		lblpass.setTextFill(Color.WHITE);
		lblLogin.setTextFill(Color.WHITE);
		lblnama.setTextFill(Color.WHITE);
		lblconfirm.setTextFill(Color.WHITE);
		
		txtuser.setMaxWidth(400);
		txtpass.setMaxWidth(400);
		
		btnregister.setMaxWidth(400);
		btnregister.setStyle("-fx-background-color: #BF6900 ; -fx-text-fill: white;");
		
		vb.getChildren().addAll(lblnama,txtname,lblusername,txtuser,lblpass,txtpass,lblconfirm,txtconfirm,lblLogin,btnregister);
		vb.setAlignment(Pos.CENTER_LEFT);
		vb.setMaxWidth(400);
		vb.setSpacing(3);
		
		lblLogin.setOnMouseClicked(e -> {
			lblLogin.getScene().setRoot(new LoginPage());
		});
		
		btnregister.setOnMouseClicked(e ->
		{
			if(txtname.getText().isEmpty())
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Name Field must be filled!");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			}
			else if (txtuser.getText().isEmpty())
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Username Field must be filled!");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			}
			else if (txtpass.getText().isEmpty())
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Password Field must be filled!");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			}
			else if (txtconfirm.getText().isEmpty())
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Password Confirm Field must be filled!");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			}
			
			if(txtname.getLength()<=3 && txtname.getLength()>=12)
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Name must be 3 - 12 Character !");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			}
			
			String email = txtuser.getText();
			
			if(!email.endsWith("@gmail.com"))
			{

				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Email Field must be ended with @gmail.com!");
		        alert.show();
		        btnregister.getScene().setRoot(new RegisPage());
			
			}
			
		});
		
		
		vb2.getChildren().addAll(iv,vb);
		vb2.setAlignment(Pos.CENTER);
		
		getChildren().addAll(iv2,vb2);  
	}
	public RegisPage()
	{
		initComp();
		addComp();
	}
}
