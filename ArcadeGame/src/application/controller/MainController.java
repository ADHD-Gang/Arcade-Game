package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	@FXML private AnchorPane hangmanScreen;
	@FXML private AnchorPane hangmanGame;
	@FXML private AnchorPane hangmanTitle;
	@FXML private Circle hangmanHead;
	@FXML private Line hangmanLeftLeg;
	@FXML private Line hangmanRightLeg;
	@FXML private Line hangmanLeftArm;
	@FXML private Line hangmanRightArm;
	@FXML private Line hangmanBody;
	@FXML private Label hangmanLettersGuessed;
	@FXML private TextField wordBox;
	@FXML private Label errorMsg;
	@FXML private Label wordToGuess;
	@FXML private Button hangmanGameEndBuffer;
	@FXML private Button connect4GameEndBuffer;
	@FXML private QuadCurve hangmanMouth;
	@FXML private Line hangmanLeftEye1;
	@FXML private Line hangmanLeftEye2;
	@FXML private Line hangmanRightEye1;
	@FXML private Line hangmanRightEye2;
	
	private int player1ScoreNum = 0;
	private int player2ScoreNum = 0;
	private int playerTurn = 0;
	private String hangmanWord = null;
	private int strikes = 0;
	
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
	@FXML public void connect4HoverEnter(MouseEvent event) {
		Button b = (Button) event.getSource();
		if(b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(255,255,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0)") {
			b.setStyle("-fx-background-radius: 35; -fx-background-color: rgb(255,255,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0)");
		}
	}
	@FXML public void connect4HoverExit(MouseEvent event) {
		Button b = (Button) event.getSource();
		if(b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(255,255,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0)") {
			b.setStyle("-fx-background-radius: 35; -fx-border-radius: 35; -fx-border-color: rgb(0,0,0)");
		}
	}	
	@FXML public void resetHoverEnter(MouseEvent event) {
		Button b = (Button) event.getSource();
		b.setStyle("-fx-background-color: rgb(50,154,255);");
	}
	@FXML public void resetHoverExit(MouseEvent event) {
		Button b = (Button) event.getSource();
		b.setStyle("-fx-background-color: rgb(30,144,255);");
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
	
	@FXML public void loadHangman(ActionEvent event) {
		System.out.println("- Function loadHangman() Triggered");
		
		getMenuBar().setVisible(false);
		getMenuBar().setDisable(true);
		getMenu().setVisible(false);
		getMenu().setDisable(true);
		
		getHangmanScreen().setDisable(false);
		getHangmanScreen().setVisible(true);
		getHangmanTitle().setDisable(false);
		getHangmanTitle().setVisible(true);
		getHangmanGame().setDisable(false);
		getHangmanGame().setVisible(true);
		clearHangmanBoard();
		modifyScorePane(10,90,Color.BLACK);
		getScorePane().setDisable(false);
		getScorePane().setVisible(true);
		updateTurn("hangman",true);
		getTurnLabel().setDisable(false);
		getTurnLabel().setVisible(true);
		
		System.out.println("- Function loadHangman() Completed");
    }
	
	@FXML public void hangmanPickWord() throws IOException {
		System.out.println("- Function hangmanPickWord() Triggered");
		
		BufferedReader wordsReader = new BufferedReader(new FileReader("data/HangmanWords.txt"));
		ArrayList<String> words = new ArrayList<String>();
		Random rand = new Random();
		int wordInt = 0;
		String line = null;
		int i = 0;
		wordToGuess.setText("");
		
		while ( (line = wordsReader.readLine()) != null)
		{
			String[] values = line.split("\n");
			for (String str : values)
			{
				words.add(str);
			}
		}
		wordsReader.close();
		
		wordInt = rand.nextInt(words.size() - 1);
		System.out.println(words.get(wordInt));
		
		for (i = 0; i < words.get(wordInt).length(); i++)
		{
			wordToGuess.setText(wordToGuess.getText() + "_");
		}
		hangmanWord = words.get(wordInt);
		
		System.out.println("- Function hangmanPickWord() Completed");
	}
	
	@FXML public void hangmanGuess(ActionEvent event) {
		System.out.println("- Function hangmanGuess() Triggered");

		int i = 0;
		char[] chars = wordToGuess.getText().toCharArray();
		StringBuilder str = new StringBuilder(hangmanLettersGuessed.getText());
		boolean right = false;
		
		if (wordBox.getText().length() <= 1)
		{
			if ( (wordBox.getText().equals("")) || !(Character.isLetter(wordBox.getText().charAt(0))) )
			{
				errorMsg.setText("Enter a valid letter!");
			}
			else
			{
				for (i = 0; i < hangmanWord.length(); i++)
				{
					if (Character.toLowerCase(wordBox.getText().charAt(0)) == hangmanWord.charAt(i))
					{
						chars[i] = Character.toLowerCase(wordBox.getText().charAt(0));
						right = true;
					}
				}
				
				wordToGuess.setText(String.valueOf(chars));
				if (right == false)
				{
					str.append(Character.toUpperCase(wordBox.getText().charAt(0)));
					hangmanLettersGuessed.setText(str.toString() + "  ");
					strikes++;
					updateTurn("hangman", true);
				}
				else
				{
					str.append(Character.toUpperCase(wordBox.getText().charAt(0)));
					hangmanLettersGuessed.setText(str.toString() + "  ");
				}
				if (hangmanLoseCheck(strikes) == false)
				{
					errorMsg.setText("Both Players Lose!\nClick Anywhere To Reset");
					
					getHangmanGameEndBuffer().setDisable(false);
					getHangmanGameEndBuffer().setVisible(true);
				}
				if (!wordToGuess.getText().contains("_"))
				{
					wordToGuess.setText(hangmanWord);
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
					getHangmanGameEndBuffer().setDisable(false);
					getHangmanGameEndBuffer().setVisible(true);
				}
			}
		}
		else
		{
			if ( (wordBox.getText().equals("")) || !(wordBox.getText().matches("^[a-zA-Z]*$")) )
			{
				errorMsg.setText("Enter a valid letter!");
			}
			else
			{
				if (wordBox.getText().equals(hangmanWord))
				{
					wordToGuess.setText(wordBox.getText());
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
					getHangmanGameEndBuffer().setDisable(false);
					getHangmanGameEndBuffer().setVisible(true);
				}
			}
		}
		System.out.println("- Function hangmanGuess() Completed");
	}
	
	public boolean hangmanLoseCheck(int strikes)
	{
		System.out.println("- Function hangmanLoseCheck() Triggered");
		
		System.out.println("- Function hangmanLoseCheck() Completed");
		switch (strikes)
		{
		case 0:
			return true;
		case 1:
			hangmanHead.setVisible(true);
			return true;
		case 2:
			hangmanBody.setVisible(true);
			return true;
		case 3:
			hangmanLeftArm.setVisible(true);
			return true;
		case 4:
			hangmanRightArm.setVisible(true);
			return true;
		case 5:
			hangmanLeftLeg.setVisible(true);
			return true;
		case 6:
			hangmanRightLeg.setVisible(true);
			hangmanLeftEye1.setVisible(true);
			hangmanLeftEye2.setVisible(true);
			hangmanRightEye1.setVisible(true);
			hangmanRightEye2.setVisible(true);
			hangmanMouth.setVisible(true);
			return false;
		default:
			return false;
		}
		
	}
	
	@FXML public void clearHangmanBoard() {
		System.out.println("- Function clearHangmanBoard() Triggered");
		hangmanHead.setVisible(false);
		hangmanLeftArm.setVisible(false);
		hangmanRightArm.setVisible(false);
		hangmanLeftLeg.setVisible(false);
		hangmanRightLeg.setVisible(false);
		hangmanBody.setVisible(false);
		hangmanLeftEye1.setVisible(false);
		hangmanLeftEye2.setVisible(false);
		hangmanRightEye1.setVisible(false);
		hangmanRightEye2.setVisible(false);
		hangmanMouth.setVisible(false);
		hangmanLettersGuessed.setText("");
		try {
			
			hangmanPickWord();
		} 
		catch (IOException e) {
			
			System.out.println("lol");
		}
		strikes = 0;
		
		System.out.println("- Function clearHangmanBoard() Completed");
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
		clearConnect4Board();
		modifyScorePane(10,90,Color.BLACK);
		getScorePane().setDisable(false);
		getScorePane().setVisible(true);
		updateTurn("connect4",true);
		getTurnLabel().setDisable(false);
		getTurnLabel().setVisible(true);
		
		System.out.println("- Function loadConnect4() Completed");
	}
	
	@FXML public void connect4PlaceTile(ActionEvent event) {
		Button b = (Button) event.getSource();
		Button b2 = (Button) b;

		if(b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(255,0,0); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);" ||
		   b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(0,0,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);") {			
			return;
		}
		
		String id = b.getId();
		String[] cords = id.split(",");
		int x = Integer.valueOf(cords[0]);
		int y = Integer.valueOf(cords[1]);
		
		/*for (int i = y; i < 9; i++) {	
			boolean emptyBelow = connect4CheckBelow(x, i);*/
			//if (emptyBelow == false) {
				System.out.println(b2.getId());
				b2.setText(getPlayerTurn() == 1? "R" : "B");
				b2.setStyle(getPlayerTurn() == 1 ? "-fx-background-radius: 35; -fx-background-color: rgb(255,0,0); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);" :
					"-fx-background-radius: 35; -fx-background-color: rgb(0,0,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);");
				updateTurn("connect4", connect4WinCheck());
			//}
		//}
	}
	
	public boolean connect4CheckBelow(int x, int y) {
		System.out.println("- Function connect4CheckBelow() Triggered");
		boolean emptyBelow = true;
		String board[][] = new String[9][9];
		int i = 0;
		int j = y + 1;
		for (Node child : getConnect4Game().getChildren()) {
			Button b = (Button) child;
			
			board[i % 9][i / 6] = b.getText();// b.getStyle();
			i++;
		}
		String letter = (getPlayerTurn() == 1 ? "R" : "B");
		if(board[x][j] == letter) {
			emptyBelow = false;
		}
		return emptyBelow;
	}
	
	/*public String connect4ButtonBelow(int x, int y) {
		String cords;
		int i = 0;
		for()
			connect4CheckBelow(x, y);
		
		cords = (x+","+y);
		return cords;
	}*/
	
	public boolean connect4WinCheck() {
		System.out.println("- Function connect4WinCheck() Triggered");
		
		boolean shouldUpdate = true;
		
		String board[][] = new String[9][9];
		int i = 0;
		int tileCount = 0;
		for (Node child : getConnect4Game().getChildren()) {
			Button b = (Button) child;
		
			//if(b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(255,0,0); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);" ||
					  // b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(0,0,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);") {
			if (b.getText() == "R" || b.getText() == "B") {

				tileCount++;
			}
			board[i % 9][i / 9] = b.getText(); //b.getStyle();
			i++;
		}
		if (tileCount == 54) {
			connect4WinDisplay(false);
			shouldUpdate = false;
		}
		
		else {
			//String letter = (getPlayerTurn() == 1 ? "-fx-background-radius: 35; -fx-background-color: rgb(255,0,0); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);" :
					//"-fx-background-radius: 35; -fx-background-color: rgb(0,0,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);");
			String letter = (getPlayerTurn() == 1 ? "R" : "B");
			if (board[0][0] == letter && board[1][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[1][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[6][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[6][0] == letter && board[7][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][0] == letter && board[5][0] == letter && board[6][0] == letter && board[7][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[1][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[1][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[6][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[6][1] == letter && board[7][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][1] == letter && board[5][1] == letter && board[6][1] == letter && board[7][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[1][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[1][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[6][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[6][2] == letter && board[7][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][2] == letter && board[5][2] == letter && board[6][2] == letter && board[7][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][3] == letter && board[1][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[1][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[6][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[6][3] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][3] == letter && board[5][3] == letter && board[6][3] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][4] == letter && board[1][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[1][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[6][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[6][4] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][4] == letter && board[5][4] == letter && board[6][4] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][5] == letter && board[1][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[1][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[6][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[6][5] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][5] == letter && board[5][5] == letter && board[6][5] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[0][1] == letter && board[0][2] == letter && board[0][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[0][2] == letter && board[0][3] == letter && board[0][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[0][3] == letter && board[0][4] == letter && board[0][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][0] == letter && board[1][1] == letter && board[1][2] == letter && board[1][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][1] == letter && board[1][2] == letter && board[1][3] == letter && board[1][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][2] == letter && board[1][3] == letter && board[1][4] == letter && board[1][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][0] == letter && board[2][1] == letter && board[2][2] == letter && board[2][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][1] == letter && board[2][2] == letter && board[2][3] == letter && board[2][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][2] == letter && board[2][3] == letter && board[2][4] == letter && board[2][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][0] == letter && board[3][1] == letter && board[3][2] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][1] == letter && board[3][2] == letter && board[3][3] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][2] == letter && board[3][3] == letter && board[3][4] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[4][1] == letter && board[4][2] == letter && board[4][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[4][2] == letter && board[4][3] == letter && board[4][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[4][3] == letter && board[4][4] == letter && board[4][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][0] == letter && board[5][1] == letter && board[5][2] == letter && board[5][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][1] == letter && board[5][2] == letter && board[5][3] == letter && board[5][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][2] == letter && board[5][3] == letter && board[5][4] == letter && board[5][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][0] == letter && board[6][1] == letter && board[6][2] == letter && board[6][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][1] == letter && board[6][2] == letter && board[6][3] == letter && board[6][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][2] == letter && board[6][3] == letter && board[6][4] == letter && board[6][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][0] == letter && board[7][1] == letter && board[7][2] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][1] == letter && board[7][2] == letter && board[7][3] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][2] == letter && board[7][3] == letter && board[7][3] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][0] == letter && board[8][1] == letter && board[8][2] == letter && board[8][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][1] == letter && board[8][2] == letter && board[8][3] == letter && board[8][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][2] == letter && board[8][3] == letter && board[8][4] == letter && board[8][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[1][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[1][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[2][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[6][0] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][0] == letter && board[6][0] == letter && board[7][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][0] == letter && board[5][0] == letter && board[6][0] == letter && board[7][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[1][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[1][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[2][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[6][1] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][1] == letter && board[6][1] == letter && board[7][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][1] == letter && board[5][1] == letter && board[6][1] == letter && board[7][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[1][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[1][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[2][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[6][2] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][2] == letter && board[6][2] == letter && board[7][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][2] == letter && board[5][2] == letter && board[6][2] == letter && board[7][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][3] == letter && board[1][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[1][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[2][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[6][3] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][3] == letter && board[6][3] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][3] == letter && board[5][3] == letter && board[6][3] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][4] == letter && board[1][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[1][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[2][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[6][4] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][4] == letter && board[6][4] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][4] == letter && board[5][4] == letter && board[6][4] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][5] == letter && board[1][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[1][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[2][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[6][5] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][5] == letter && board[6][5] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][5] == letter && board[5][5] == letter && board[6][5] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[0][1] == letter && board[0][2] == letter && board[0][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[0][2] == letter && board[0][3] == letter && board[0][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[0][3] == letter && board[0][4] == letter && board[0][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][0] == letter && board[1][1] == letter && board[1][2] == letter && board[1][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][1] == letter && board[1][2] == letter && board[1][3] == letter && board[1][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][2] == letter && board[1][3] == letter && board[1][4] == letter && board[1][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][0] == letter && board[2][1] == letter && board[2][2] == letter && board[2][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][1] == letter && board[2][2] == letter && board[2][3] == letter && board[2][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][2] == letter && board[2][3] == letter && board[2][4] == letter && board[2][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][0] == letter && board[3][1] == letter && board[3][2] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][1] == letter && board[3][2] == letter && board[3][3] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][2] == letter && board[3][3] == letter && board[3][4] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[4][1] == letter && board[4][2] == letter && board[4][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[4][2] == letter && board[4][3] == letter && board[4][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[4][3] == letter && board[4][4] == letter && board[4][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][0] == letter && board[5][1] == letter && board[5][2] == letter && board[5][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][1] == letter && board[5][2] == letter && board[5][3] == letter && board[5][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][2] == letter && board[5][3] == letter && board[5][4] == letter && board[5][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][0] == letter && board[6][1] == letter && board[6][2] == letter && board[6][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][1] == letter && board[6][2] == letter && board[6][3] == letter && board[6][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[6][2] == letter && board[6][3] == letter && board[6][4] == letter && board[6][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][0] == letter && board[7][1] == letter && board[7][2] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][1] == letter && board[7][2] == letter && board[7][3] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[7][2] == letter && board[7][3] == letter && board[7][3] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][0] == letter && board[8][1] == letter && board[8][2] == letter && board[8][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][1] == letter && board[8][2] == letter && board[8][3] == letter && board[8][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[8][2] == letter && board[8][3] == letter && board[8][4] == letter && board[8][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][0] == letter && board[1][1] == letter && board[2][2] == letter && board[3][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][0] == letter && board[2][1] == letter && board[3][2] == letter && board[4][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][0] == letter && board[3][1] == letter && board[4][2] == letter && board[5][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][0] == letter && board[4][1] == letter && board[5][2] == letter && board[6][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][0] == letter && board[5][1] == letter && board[6][2] == letter && board[7][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][0] == letter && board[6][1] == letter && board[7][2] == letter && board[8][3] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][1] == letter && board[1][2] == letter && board[2][3] == letter && board[3][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][1] == letter && board[2][2] == letter && board[3][3] == letter && board[4][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][1] == letter && board[3][2] == letter && board[4][3] == letter && board[5][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][1] == letter && board[4][2] == letter && board[5][3] == letter && board[6][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][1] == letter && board[5][2] == letter && board[6][3] == letter && board[7][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][1] == letter && board[6][2] == letter && board[7][3] == letter && board[8][4] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][2] == letter && board[1][3] == letter && board[2][4] == letter && board[3][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][2] == letter && board[2][3] == letter && board[3][4] == letter && board[4][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][2] == letter && board[3][3] == letter && board[4][4] == letter && board[5][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][2] == letter && board[4][3] == letter && board[5][4] == letter && board[6][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][2] == letter && board[5][3] == letter && board[6][4] == letter && board[7][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][2] == letter && board[6][3] == letter && board[7][4] == letter && board[8][5] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][3] == letter && board[1][2] == letter && board[2][1] == letter && board[3][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][3] == letter && board[2][2] == letter && board[3][1] == letter && board[4][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][3] == letter && board[3][2] == letter && board[4][1] == letter && board[5][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][3] == letter && board[4][2] == letter && board[5][1] == letter && board[6][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][3] == letter && board[5][2] == letter && board[6][1] == letter && board[7][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][3] == letter && board[6][2] == letter && board[7][1] == letter && board[8][0] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][4] == letter && board[1][3] == letter && board[2][2] == letter && board[3][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][4] == letter && board[2][3] == letter && board[3][2] == letter && board[4][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][4] == letter && board[3][3] == letter && board[4][2] == letter && board[5][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][4] == letter && board[4][3] == letter && board[5][2] == letter && board[6][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][4] == letter && board[5][3] == letter && board[6][2] == letter && board[7][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][4] == letter && board[6][3] == letter && board[7][2] == letter && board[8][1] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[0][5] == letter && board[1][4] == letter && board[2][3] == letter && board[3][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[1][5] == letter && board[2][4] == letter && board[3][3] == letter && board[4][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[2][5] == letter && board[3][4] == letter && board[4][3] == letter && board[5][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[3][5] == letter && board[4][4] == letter && board[5][3] == letter && board[6][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[4][5] == letter && board[5][4] == letter && board[6][3] == letter && board[7][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			else if (board[5][5] == letter && board[6][4] == letter && board[7][3] == letter && board[8][2] == letter) {
				connect4WinDisplay(true);
				shouldUpdate = false;
			}
			
		}
		
		System.out.println("- Function connect4WinCheck() Completed");
		return shouldUpdate;
	}

	
	public void connect4WinDisplay(Boolean b) {
		System.out.println("- - Function connect4WinDisplay() Triggered");
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
		getConnect4GameEndBuffer().setDisable(false);
		getConnect4GameEndBuffer().setVisible(true);
		System.out.println("- - Function connect4WinDisplay() Completed");
	}
	
	public void clearConnect4Board() {
		for (Node child : getConnect4Game().getChildren()) {
			Button b = (Button) child;
			if (b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(255,0,0); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);" ||
					   b.getStyle() == "-fx-background-radius: 35; -fx-background-color: rgb(0,0,255); -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);") {
				b.setText("");
				b.setStyle("-fx-background-radius: 35; -fx-border-radius: 35; -fx-border-color: rgb(0,0,0);");
			}
		}
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
			getTurnLabel().setFont(Font.font("System", FontWeight.BOLD, 32));
			if (getPlayerTurn() == 0) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(R)" : "(B)"));
			}
			else if (getPlayerTurn() == 2) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(R)" : "(B)"));
			}
			else {
				setPlayerTurn(2);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn " + (getPlayerTurn() == 1 ? "(R)" : "(B)"));
			}
		}
		if (str == "hangman" && b == true) {
			getTurnLabel().setFont(Font.font("System", FontWeight.BOLD, 32));
			if (getPlayerTurn() == 0) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn ");
			}
			else if (getPlayerTurn() == 2) {
				setPlayerTurn(1);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn ");
			}
			else {
				setPlayerTurn(2);
				setTurnLabel("Player " + getPlayerTurn() + "'s Turn ");
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
	@FXML public void disableHangmanResultDisplay() {
		getHangmanGameEndBuffer().setVisible(false);
		getHangmanGameEndBuffer().setDisable(true);
		updateTurn("hangman",true);
		clearHangmanBoard();
	}
	@FXML public void disableConnect4ResultDisplay() {
		getConnect4GameEndBuffer().setVisible(false);
		getConnect4GameEndBuffer().setDisable(true);
		updateTurn("connect4",true);
		clearConnect4Board();
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
	public AnchorPane getHangmanScreen() {
		return hangmanScreen;
	}
	public AnchorPane getHangmanGame() {
		return hangmanGame;
	}
	public AnchorPane getHangmanTitle() {
		return hangmanTitle;
	}
	public Circle getHangmanHead() {
		return hangmanHead;
	}
	public Label getHangmanLettersGuessed() {
		return hangmanLettersGuessed;
	}
	public String getHangmanWord() {
		return hangmanWord;
	}
	public int getStrikes() {
		return strikes;
	}
	public Button getHangmanGameEndBuffer() {
		return hangmanGameEndBuffer;
	}
	public Button getConnect4GameEndBuffer() {
		return connect4GameEndBuffer;
	}
	
}
