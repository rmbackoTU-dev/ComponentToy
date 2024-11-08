package examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class LabelExample extends Application {
	
	private Group root;
	private GridPane baseGrid;
	
	private Scene createMainPane()
	{
		root=new Group();
		Scene rootScene=new Scene(this.root, 800, 400, Color.WHITE);
		baseGrid=new GridPane();
		addLabels();
		addExitButton();
		root.getChildren().add(baseGrid);
		return rootScene;
	}
	
	private void addLabels()
	{
		Image bookImage=new Image(getClass().getResourceAsStream("../images/book.png"));
		Image searchGlass=new Image(getClass().getResourceAsStream("../images/search_glass_48.png"));
		
		Label labelExampleOne=new Label("Search",new ImageView(searchGlass));
		Label labelExampleTwo=new Label("Search");
		Label labelExampleThree=new Label("Book");
		
		labelExampleThree.setGraphic(new ImageView(bookImage));
		labelExampleThree.setTextFill(Color.RED);
		labelExampleOne.setFont(new Font("Times New Roman", 32));
		labelExampleTwo.setFont(new Font("Arial",32));
		labelExampleThree.setFont(new Font("Times New Roman", 32));
		
		GridPane.setRowIndex(labelExampleOne, 0);
		GridPane.setColumnIndex(labelExampleOne,0);
		GridPane.setRowIndex(labelExampleTwo, 0);
		GridPane.setColumnIndex(labelExampleTwo, 1);
		GridPane.setRowIndex(labelExampleThree, 0);
		GridPane.setColumnIndex(labelExampleThree,2);
		
		this.baseGrid.getChildren().addAll(labelExampleOne, labelExampleTwo, labelExampleThree);
	}
	
	
	private void addExitButton()
	{
		Button exitButton=new Button("Exit");
		exitButton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						Platform.exit();
					}
				});
		GridPane.setRowIndex(exitButton, 1);
		GridPane.setColumnIndex(exitButton, 1);
		baseGrid.getChildren().add(exitButton);
	}
	
	
	@Override
	public void start(Stage primaryStage)throws Exception
	{
		primaryStage.setTitle("Label example");
		primaryStage.setScene(createMainPane());
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
