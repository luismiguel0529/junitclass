package game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream outputStream;

    @Before
    public void setup(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void whenQuitThenExitGame(){
        when(scanner.nextLine()).thenReturn("Quit");
        game.play();

        assertTrue(outputStream.toString().contains("Let's play Rock, Paper, Scissors!"));
    }

    @Test
    public void whenChooseRockThenBeatsScissors(){
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);
        game.play();

        assertTrue(outputStream.toString().contains("Computer chose scissors"));
        assertTrue(outputStream.toString().contains("you win!"));
    }

    @Test
    public void whenChooseScissorsThenBeatsPaper(){
        when(scanner.nextLine()).thenReturn("Scissors").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);
        game.play();

        assertTrue(outputStream.toString().contains("Computer chose paper"));
        assertTrue(outputStream.toString().contains("you win!"));
    }

    @Test
    public void whenChoosePaperThenBeatsRock(){
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);
        game.play();

        assertTrue(outputStream.toString().contains("Computer chose rock"));
        assertTrue(outputStream.toString().contains("you win!"));
    }

    @Test
    public void whenBothRockThenTie(){
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);
        game.play();

        assertTrue(outputStream.toString().contains("Computer chose rock"));
        assertTrue(outputStream.toString().contains("It's a tie"));
    }

    @Test
    public void whenChooseRockThenBeatsPaper(){
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);
        game.play();

        assertTrue(outputStream.toString().contains("Computer chose paper"));
        assertTrue(outputStream.toString().contains("you lose."));
    }
}
