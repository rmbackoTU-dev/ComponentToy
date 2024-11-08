package examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonExample extends Application {

	private GridPane baseGrid;
	//result will contain the result of the button clicked.
	private Label result;
	private static int initScreen;
	private Stage mainStage;
	
	private Scene createMainPane()
	{
		Group root=new Group();
		Scene rootScene=new Scene(root, 800, 400, Color.WHITE);
		baseGrid=new GridPane();
		addButtons(initScreen);
		root.getChildren().add(baseGrid);
		return rootScene;
	}
	
	private void addButtons(int num)
	{
		Image checkMark=new Image(getClass().getResourceAsStream("../images/check.png"));
		Image crossMark=new Image(getClass().getResourceAsStream("../images/cross.png"));
		
		//Empty Button
		Button buttonOne=new Button();
		//Text Buttons
		Button buttonTwo=new Button("Accept");
		Button buttonThree=new Button("Decline");
		//Image Buttons
		Button buttonFour=new Button("Accept", new ImageView(checkMark));
		Button buttonFive=new Button("Decline", new ImageView(crossMark));
		
		buttonOne.setText("Accept");
		
		if(num == 1)
		{
			GridPane.setColumnIndex(buttonOne, 1);
			GridPane.setRowIndex(buttonOne, 0);
			buttonOne.setOnAction((ActionEvent e) -> 
			{
				Scene newScene=showResult("accept");
				this.mainStage.setScene(newScene);
				
				
			});
			this.baseGrid.getChildren().add(buttonOne);
		}
		else if(num == 2)
		{
			GridPane.setColumnIndex(buttonTwo, 1);
			GridPane.setRowIndex(buttonTwo, 0);
			GridPane.setColumnIndex(buttonThree, 3);
			GridPane.setRowIndex(buttonThree, 0);
			buttonTwo.setOnAction((ActionEvent e) -> 
			{
				Scene newScene=showResult("accept");
				this.mainStage.setScene(newScene);
			});
			buttonThree.setOnAction((ActionEvent e) -> 
			{
				Scene newScene=showResult("deny");
				this.mainStage.setScene(newScene);
			});
			this.baseGrid.getChildren().addAll(buttonTwo, buttonThree);
		}
		else if(num == 3)
		{
			GridPane.setColumnIndex(buttonFour, 1);
			GridPane.setRowIndex(buttonFour, 0);
			GridPane.setColumnIndex(buttonFive, 3);
			GridPane.setRowIndex(buttonFive, 0);
			buttonFour.setOnAction((ActionEvent e) -> 
			{
				Scene newScene=showResult("accept");
				this.mainStage.setScene(newScene);
			});
			buttonFive.setOnAction((ActionEvent e) -> 
			{
				Scene newScene=showResult("deny");
				this.mainStage.setScene(newScene);
			});
			this.baseGrid.getChildren().addAll(buttonFour, buttonFive);
		}	
		
	}	
	
	
	private Scene showResult(String result)
	{
		Group labelGroup=new Group();
		Scene LabelScene=new Scene(labelGroup, 800, 400, Color.WHITE);
		BorderPane baseLabelPane=new BorderPane();
		HBox labelBox=new HBox();
		this.result=new Label();
		if(result.matches("accept"))
		{
			this.result.setText("Accepted");
		}
		else if(result.matches("deny"))
		{
			this.result.setText("Denied");
		}
		else
		{
			//Something went wrong tell the user.
			this.result.setText("Error");
		}
		HBox.setHgrow(labelBox, Priority.ALWAYS);
		labelBox.getChildren().add(this.result);
		labelBox.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(labelBox, Pos.CENTER);
		baseLabelPane.setCenter(labelBox);
		labelGroup.getChildren().add(baseLabelPane);
		return LabelScene;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		this.mainStage=primaryStage;
		this.mainStage.setTitle("Button example");
		this.mainStage.setScene(createMainPane());
		this.mainStage.show();
	}
	
	public static void main(String[] args)
	{
		int argLength=args.length;
		if(argLength < 1)
		{
			//Use One by default unless arg is specified
			initScreen=1;
		}
		else
		{
			initScreen=Integer.parseInt(args[0]);
		}
		//Launch turns these into named parameters we will need to figure this out later
		launch(args);
		
	}
}
