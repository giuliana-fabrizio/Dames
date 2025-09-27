package control;

public class ControlScore {
    private int lost;

    private int score;

    public ControlScore() {
        this.lost = 0;
        this.score = 0;
    }

    public int getLost() {
        return this.lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
