package game;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        //start game
        startGame();
        String choice = input.nextLine().toUpperCase(); //prompt response

        //initialize variables
        ScoreBoard scoreBoard = new ScoreBoard();

        while (!choice.equals("QUIT")) //do the following if the user does not put in "quit"
        {
            GameOption choicenum = getChoiceNum(choice);

            while (choicenum == null) //continue while user input is still not valid
            {
                System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                choice = input.nextLine().toUpperCase();
                choicenum = getChoiceNum(choice);
            }

            GameOption compnum = getChoiceComputer();


            resolveGamePlay(scoreBoard, choicenum, compnum);
            printResults(scoreBoard);
            choice = input.nextLine().toUpperCase(); //prompt for new user input
        }
    }

    private void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTies()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private void resolveGamePlay(ScoreBoard scoreBoard, GameOption choicenum, GameOption compnum) {
        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incrementTies();
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS
                || choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER
                ||choicenum == GameOption.PAPER && compnum == GameOption.ROCK)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else //otherwise computer wins
        {
            System.out.println("you lose.");
            scoreBoard.incrementLosses();
        }
    }

    private GameOption getChoiceComputer() {
        GameOption gameOption = GameOption.values()[random.nextInt(3)];//computer generate random num
        System.out.println("Computer chose " + gameOption.toString().toLowerCase());

        return gameOption;

    }

    private void startGame() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private GameOption getChoiceNum(String choice){

        GameOption gameOption = null;

        try {
            gameOption = GameOption.valueOf(choice);
        } catch (Exception e){
            return null;
        }
        return gameOption;
    }
}