package game;

public class ScoreBoard {

    private Integer ties;
    private Integer wins;
    private Integer losses;

    public ScoreBoard() {
        this.ties = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public Integer getTies() {
        return ties;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void incrementWins(){
        wins++;
    }

    public void incrementLosses(){
        losses++;
    }

    public void incrementTies(){
        ties++;
    }
}
