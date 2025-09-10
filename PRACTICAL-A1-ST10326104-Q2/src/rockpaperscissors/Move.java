package RockPaperScissors;

public class Move {
    protected String name;
    protected String beats;

    public Move(String name, String beats) {
        this.name = name;
        this.beats = beats;
    }

    public String getName() {
        return name;
    }

    public String compare(Move other) {
        if (this.name.equals(other.name)) {
            return "Draw! Both chose " + name;
        } else if (this.beats.equals(other.name)) {
            return "You win! " + name + " beats " + other.name;
        } else {
            return "You lose! " + other.name + " beats " + name;
        }
    }
}
