package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {
	@FXML private AnchorPane home;
	@FXML private AnchorPane menu;
	@FXML private AnchorPane scorePane;
	@FXML private Label turnLabel;
	@FXML private AnchorPane menuBar;
	@FXML private AnchorPane menuStartScreen;
	@FXML private AnchorPane tictactoeScreen;
	@FXML private AnchorPane tictactoeTitle;
	@FXML private AnchorPane tictactoeGame;
	@FXML private AnchorPane connect4Screen;
	@FXML private AnchorPane connect4Title;
	@FXML private AnchorPane connect4Game;
	@FXML private Button gameEndBuffer;
	@FXML private Label player1Score;
	@FXML private Label player2Score;
	
	private int player1ScoreNum = 0;
	private int player2ScoreNum = 0;
	private int playerTurn = 0;
	
	public void initialize() {
		System.out.println("- Function initialize() Triggered");
		// Disabling
		disableAllAnchors();
		
		// Enabling
		getHome().setDisable(false);
		getHome().setVisible(true);
		getMenu().setDisable(false);
		getMenu().setVisible(true);
		getMenuStartScreen().setDisable(false);
		getMenuStartScreen().setVisible(true);
		System.out.println("- Function initialize() Completed");
	}
	
	@FXML public void hoverHighlightEnter(MouseEvent event) {
		//System.out.println(" - Function (menuBarHoverEnter) Triggered");
		Button b = (Button) event.getSource();
		b.setStyle("-fx-background-color: rgb(240,240,240);");
		//System.out.println(" - Function (menuBarHoverEnter) Completed");
	}
	@FXML public void hoverHighlightExit(MouseEvent event) {
		//System.out.println(" - Function (menuBarHoverExit) Triggered");
		Button b = (Button) event.getSource();
		b.setStyle("-fx-background-color: rgb(210,210,210);");
		//System.out.println(" - Function (menuBarHoverExit) Completed");
	}
	
	@FXML public void tictactoeHoverEnter(MouseEvent event) {
		Button b = (Button) event.getSource();
		if (b.getText() == "X" || b.getText() == "O") {
			return;
		}
		b.setStyle("-fx-background-color: rgb(240,240,240);");
	}
	@FXML public void tictactoeHoverExit(MouseEvent event) {
		Button b = (Button) event.getSource();
		b.setStyle("-fx-background-color: rgb(210,210,210);");
	}
	
	@FXML public void loadMenu(ActionEvent event) {
		System.out.println("- Function loadMenu() Triggered");
		
		disableAllAnchors();
		
		getHome().setDisable(false);
		getHome().setVisible(true);
		getMenu().setDisable(false);
		getMenu().setVisible(true);
		getMenuBar().setVisible(true);
		getMenuBar().setDisable(false);
		modifyScorePane(0,0,Color.WHITE);
		getScorePane().setDisable(false);
		getScorePane().setVisible(true);
		System.out.println("- Function loadMenu() Completed");
	}
	
	@FXML public void loadTicTacToe(ActionEvent event) {
		System.out.println("- Function loadTicTacToe() Triggered");
		
		getMenuBar().setVisible(false);
		getMenuBar().setDisable(true);
		getMenu().setVisible(false);
		getMenu().setDisable(true);
		
		getTicTacToeScreen().setDisable(false);
		getTicTacToeScreen().setVisible(true);
		getTicTacToeTitle().setDisable(false);
		getTicTacToeTitle().setVisible(true);
		getTicTacToeGame().setDisable(false);
		getTicTacToeGame().setVisible(true);
		clearTicTacToeBoard();
		modifyScorePane(10,90,Color.BLACK);
		getScorePane().setDisable(false);
		getScorePane().setVisible(true);
		updateTurn("tictactoe",true);
		getTurnLabel().setDisable(false);
		getTurnLabel().setVisible(true);
		
		
		System.out.println("- Function loadTicTacToe() Completed");
	}
	
	@FXML public void tictactoePlaceTile(ActionEvent event) {
		Button b = (Button) event.getSource();
		if (b.getText() == "X" || b.getText() == "O") {
			return;
		}
		b.setText(getPlayerTurn() == 1 ? "X" : "O");
		updateTurn("tictactoe", tictactoeWinCheck());
	}
	
	public boolean tictactoeWinCheck() {
		System.out.println("- Function tictactoeWinCheck() Triggered");
		
		boolean shouldUpdate = true;
		
		String board[][] = new String[3][3];
		int i = 0;
		int tileCount=0;
		for (Node child : getTicTacToeGame().getChildren()) {
			Button b = (Button) child;
			if (b.getText() == "X" || b.getText() == "O") {
				tileCount++;
			}
			board[i % 3][i / 3] = b.getText();
			i++;
		}
		if (tileCount == 9) {
			tictactoeWinDisplay(false);
			shouldUpdate = false;
		}
		else {
			String letter = (getPlayerTurn() == 1 ? "X" : "O");
			if (board[0][0] == letter && board[1][0] == letter && board[2][0] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[1][1] == letter && board[2][1] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[1][2] == letter && board[2][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[0][1] == letter && board[0][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][0] == letter && board[1][1] == letter && board[1][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][0] == letter && board[2][1] == letter && board[2][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[1][1] == letter && board[2][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][0] == letter && board[1][1] == letter && board[0][2] == letter) {
				tictactoeWinDisplay(true);
				shouldUpdate = false;
			}
		}
		
		System.out.println("- Function tictactoeWinCheck() Completed");
		return shouldUpdate;
	}
	
	public void tictactoeWinDisplay(Boolean b) {
		System.out.println("- - Function tictactoeWinDisplay() Triggered");
		if (b == true) {
			getTurnLabel().setFont(Font.font("System", FontWeight.BOLD, 32));
			setTurnLabel("Player " + getPlayerTurn() + " WINS!");
			if (getPlayerTurn() == 1) {
				setPlayer1ScoreNum(getPlayer1ScoreNum() + 1);
				setPlayer1ScoreLabel(String.valueOf(getPlayer1ScoreNum()));
			}
			else {
				setPlayer2ScoreNum(getPlayer2ScoreNum() + 1);
				setPlayer2ScoreLabel(String.valueOf(getPlayer2ScoreNum()));
			}
		}
		else {
			setTurnLabel("The Game Ended In A Draw!");
			getTurnLabel().setFont(Font.font("System", FontWeight.BOLD, 20));
		}
		getGameEndBuffer().setDisable(false);
		getGameEndBuffer().setVisible(true);
		System.out.println("- - Function tictactoeWinDisplay() Completed");
	}
	
	public void clearTicTacToeBoard() {
		for (Node child : getTicTacToeGame().getChildren()) {
			Button b = (Button) child;
			b.setText("");
		}
	}
	
	@FXML public void loadConnect4(ActionEvent event) {
		System.out.println("- Function loadConnect4() Triggered");
		
		getMenuBar().setVisible(false);
		getMenuBar().setDisable(true);
		getMenu().setVisible(false);
		getMenu().setDisable(true);
		
		getConnect4Screen().setDisable(false);
		getConnect4Screen().setVisible(true);
		getConnect4Title().setDisable(false);
		getConnect4Title().setVisible(true);
		getConnect4Game().setDisable(false);
		getConnect4Game().setVisible(true);
		//clearConnect4Board();
		modifyScorePane(10,90,Color.BLACK);
		getScorePane().setDisable(false);
		getScorePane().setVisible(true);
		updateTurn("connect4",true);
		getTurnLabel().setDisable(false);
		getTurnLabel().setVisible(true);
		
		System.out.println("- Function loadConnect4() Completed");
	}
	
	public void updateTurn(String str, boolean b) {
		if (str == "tictactoe" && b == true) {
			getTurnLabel().setFont(Font.font("System", FontWeight.BOLD, 32));
			if (getPlayerTurn() == 0) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(X)" : "(O)"));
			}
			else if (getPlayerTurn() == 2) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(X)" : "(O)"));
			}
			else {
				setPlayerTurn(2);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(X)" : "(O)"));
			}
		}
		if (str == "connect4" && b == true) {
			// TO-DO Connect 4 Turn Structure
			if (getPlayerTurn() == 0) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(⚫)" : "(⚪)"));
			}
			else if (getPlayerTurn() == 2) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(⚫)" : "(⚪)"));
			}
			else {
				setPlayerTurn(2);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(⚫)" : "(⚪)"));
			}
		}
	}
	
	public void modifyScorePane(int x, int y, Color color) {
		getScorePane().setLayoutX(x);
		getScorePane().setLayoutY(y);
		for (Node child : getScorePane().getChildren()) {
			Label label = (Label) child;
			label.setTextFill(color);
		}
	}
	
	@FXML public void disableResultDisplay() {
		getGameEndBuffer().setVisible(false);
		getGameEndBuffer().setDisable(true);
		updateTurn("tictactoe",true);
		clearTicTacToeBoard();
	}
	
	public void disableAllAnchors() {
		System.out.println("- - Function disableAllAnchors() Triggered");
		
		getConnect4Screen().setVisible(false);
		getConnect4Screen().setDisable(true);
		getConnect4Title().setVisible(false);
		getConnect4Title().setDisable(true);
		getConnect4Game().setVisible(false);
		getConnect4Game().setDisable(true);
		
		getTicTacToeTitle().setVisible(false);
		getTicTacToeTitle().setDisable(true);
		getTicTacToeGame().setVisible(false);
		getTicTacToeGame().setDisable(true);
		getTicTacToeScreen().setVisible(false);
		getTicTacToeScreen().setDisable(true);
		
		getMenuStartScreen().setVisible(false);
		getMenuStartScreen().setDisable(true);
		
		getMenuBar().setVisible(false);
		getMenuBar().setDisable(true);
		getMenu().setVisible(false);
		getMenu().setDisable(true);
		
		getScorePane().setVisible(false);
		getScorePane().setDisable(true);
		
		getTurnLabel().setVisible(false);
		getTurnLabel().setDisable(true);
		getGameEndBuffer().setVisible(false);
		getGameEndBuffer().setDisable(true);
		
		getHome().setVisible(false);
		getHome().setDisable(true);
		System.out.println("- - Function disableAllAnchors() Completed");
	}
	
	public void setPlayerTurn(int num) {
		this.playerTurn = num;
	}
	public void setTurnLabel(String str) {
		System.out.println("- - - " + str);
		this.turnLabel.setText(str);
	}
	public void setPlayer1ScoreLabel (String str) {
		this.player1Score.setText(str);
	}
	public void setPlayer2ScoreLabel (String str) {
		this.player2Score.setText(str);
	}
	public void setPlayer1ScoreNum(int num) {
		this.player1ScoreNum = num;
	}
	public void setPlayer2ScoreNum(int num) {
		this.player2ScoreNum = num;
	}
	
	public AnchorPane getHome() {
		return this.home;
	}
	public AnchorPane getMenu() {
		return this.menu;
	}
	public AnchorPane getMenuBar() {
		return this.menuBar;
	}
	public AnchorPane getScorePane() {
		return this.scorePane;
	}
	public Label getTurnLabel() {
		return this.turnLabel;
	}
	public Button getGameEndBuffer() {
		return this.gameEndBuffer;
	}
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	public AnchorPane getMenuStartScreen() {
		return this.menuStartScreen;
	}
	public AnchorPane getTicTacToeScreen() {
		return this.tictactoeScreen;
	}
	public AnchorPane getTicTacToeTitle() {
		return this.tictactoeTitle;
	}
	public AnchorPane getTicTacToeGame() {
		return this.tictactoeGame;
	}
	public AnchorPane getConnect4Screen() {
		return this.connect4Screen;
	}
	public AnchorPane getConnect4Title() {
		return this.connect4Title;
	}
	public AnchorPane getConnect4Game() {
		return this.connect4Game;
	}
	public Label getPlayer1Score() {
		return this.player1Score;
	}
	public Label getPlayer2Score() {
		return this.player2Score;
	}
	public int getPlayer1ScoreNum() {
		return this.player1ScoreNum;
	}
	public int getPlayer2ScoreNum() {
		return this.player2ScoreNum;
	}
}
