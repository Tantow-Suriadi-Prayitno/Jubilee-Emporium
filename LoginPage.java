package pages;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class LoginPage extends StackPane{
	
	private Button btnlogin;
	private Label lblregis,lblpass,lblusername;
	private TextField txtuser;
	private PasswordField txtpass;
	private Media media,sound;
	private MediaPlayer mp,sp;
	private MediaView mv,sv;
	private ImageView iv;
	private Image img;
	private VBox vb,vb2;
	
	
	
	private void initComp()
	{
		btnlogin = new Button("Login");
		lblregis = new Label("Click here to register");
		lblpass = new Label("Password");
		lblusername = new Label("Username");
		txtuser = new TextField();
		txtpass = new PasswordField();
		
		img = new Image(new File("assets/image/logo.png").toURI().toString());
		iv = new ImageView(img);
		
		vb = new VBox();
		vb2 = new VBox();
		media = new Media(new File("assets/video/video.mp4").toURI().toString());
		sound = new Media(new File("assets/audio/bgm.mp3").toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaView(mp);
		sp = new MediaPlayer(sound);
		sv = new MediaView(sp);
		
	}
	
	private void addComp()
	{
		
		lblusername.setTextFill(Color.WHITE);
		lblpass.setTextFill(Color.WHITE);
		lblregis.setTextFill(Color.WHITE);
		
		txtuser.setMaxWidth(400);
		txtpass.setMaxWidth(400);
		
		btnlogin.setMaxWidth(400);
		btnlogin.setStyle("-fx-background-color: #BF6900 ; -fx-text-fill: white;");
		
		vb.getChildren().addAll(lblusername,txtuser,lblpass,txtpass,lblregis,btnlogin);
		vb.setAlignment(Pos.CENTER_LEFT);
		vb.setMaxWidth(400);
		vb.setSpacing(3);
		
		lblregis.setOnMouseClicked(e -> {
			lblregis.getScene().setRoot(new RegisPage());
		});
		
		btnlogin.setOnAction(e->
		{
			String email = txtuser.getText();
			String password = txtpass.getText();
			
			if(email.isEmpty() && password.isEmpty())
			{

				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Email and Password Field must be filled!");
		        alert.show();
		        btnlogin.getScene().setRoot(new LoginPage());
			}
			
			else if (email.isEmpty())
				
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Email Field must be filled!");
		        alert.show();
		        btnlogin.getScene().setRoot(new LoginPage());

			}
			
			else if (password.isEmpty())
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Password field must be filled!");
		        alert.show();
		        btnlogin.getScene().setRoot(new LoginPage());

			}
			
			if(!email.endsWith("@gmail.com"))
			{

				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Email Field must be ended with @gmail.com!");
		        alert.show();
		        btnlogin.getScene().setRoot(new LoginPage());
			
			}
			
			if(email.equals("admin@gmail.com") && password.equals("admin"))
			{
				btnlogin.getScene().setRoot(new AdminWin());
			}
			else 
			{
				btnlogin.getScene().setRoot(new ShopWin());
			}
		});
		
		vb2.getChildren().addAll(iv,vb);
		vb2.setAlignment(Pos.CENTER);
		
		sp.setAutoPlay(true);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		
		mp.setAutoPlay(true);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		
		getChildren().addAll(mv,sv,vb2);
			
	}
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
		initComp();
		addComp();
	}

}
