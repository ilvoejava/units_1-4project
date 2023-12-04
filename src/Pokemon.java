import java.util.Scanner;
import java.lang.Math;

public class Pokemon {
    private int attack;
    private int AIattack;
    private int defense;
    private int health;
    private int maxHealth;
    private int speed;
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    public Pokemon (int health, int attack, int defense, int speed) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
        maxHealth = health;
    }
    public Pokemon (String move1, String move2, String move3, String move4) {
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }
    public double dice() {
        double multiplier = 0;
        int dice = (int)(Math.random() * 6) + 1;
        if (dice == 1) {
            multiplier = 0.8;
        } else if (dice == 2) {
            multiplier = 0.9;
        } else if (dice == 3) {
            multiplier = 1;
        } else if (dice == 4) {
            multiplier = 1.1;
        } else if (dice == 5) {
            multiplier = 1.2;
        } else if (dice == 6) {
            multiplier = 1.3;
        }
        return multiplier;
    }

    public void increaseAttack(int amount) {
        attack += amount;
    }

    public void increaseDefense(int amount) {
        defense += amount;
    }

    public void increaseHealth(int amount) {
        health += amount;
    }
    public void decreaseAttack(int amount) {
        attack -= amount;
    }

    public void decreaseDefense(int amount) {
        defense -= amount;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }
    public void setAttack(int newAttack) {
        attack = newAttack;
    }
    public void setAIAttack(int newAttack) {
        AIattack = newAttack;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getAttack() {
        return attack;
    }
    public int getAIAttack() {
        return AIattack;
    }
    public int getDefense() {
        return defense;
    }

    public void moves(String pokemon) {
        if (pokemon.equals("Venusaur")) {
            move1 = "Solar Beam";
            move2 = "Sludge Bomb";
            move3 = "Vine Whip";
            move4 = "Giga Drain";
        }
        if (pokemon.equals("Charizard")) {
            move1 = "Flamethrower";
            move2 = "Fire Spin";
            move3 = "Air Slash";
            move4 = "Dragon Claw";
        }
        if (pokemon.equals("Blastoise")) {
            move1 = "Hydro Pump";
            move2 = "Ice Beam";
            move3 = "Flash Cannon";
            move4 = "Skull Bash";

        }
    }
    public void VenusaurStats(String move) { //subject to change
        if (move.equals(move1)) {
            setAttack(45);
        } else if (move.equals(move2)) {
            setAttack(40);
        } else if (move.equals(move3)) {
            setAttack(20);
        } else if (move.equals(move4)) {
            setAttack(15);
            health += (int) (health * dice() / 5.0);
        }
    }
    public void CharizardStats(String move) { //subject to change
        if (move.equals(move1)) {
            setAttack(40);
        } else if (move.equals(move2)) {
            setAttack(15);
        } else if (move.equals(move3)) {
            setAttack(30);
        } else if (move.equals(move4)) {
            setAttack(35);
        }
    }
    public void BlastoiseStats(String move) { //subject to change
        if (move.equals(move1)) {
            setAttack(40);
        } else if (move.equals(move2)) {
            setAttack(30);
        } else if (move.equals(move3)) {
            setAttack(30);
        } else if (move.equals(move4)) {
            setAttack(25);
        }
    }
    public String AImove(String computer) {
        int moveNum = (int)(Math.random() * 4) + 1;
        String chosenMove = "";
        if (moveNum == 1) {
            chosenMove = move1;
            if (computer.equals("Venusaur")) {
                setAIAttack(45);
            } else if (computer.equals("Charizard")) {
                setAIAttack(40);
            } else if (computer.equals("Blastoise")) {
                setAIAttack(40);
            }
        } else if (moveNum == 2) {
            chosenMove = move2;
            if (computer.equals("Venusaur")) {
                setAIAttack(40);
            } else if (computer.equals("Charizard")) {
                setAIAttack(15);
            } else if (computer.equals("Blastoise")) {
                setAIAttack(30);
            }
        } else if (moveNum == 3) {
            chosenMove = move3;
            if (computer.equals("Venusaur")) {
                setAIAttack(20);
            } else if (computer.equals("Charizard")) {
                setAIAttack(30);
            } else if (computer.equals("Blastoise")) {
                setAIAttack(30);
            }
        } else {
            chosenMove = move4;
            if (computer.equals("Venusaur")) {
                setAIAttack(0);
                health += (int) (health * dice() / 10.0);
            } else if (computer.equals("Charizard")) {
                setAIAttack(35);
            } else if (computer.equals("Blastoise")) {
                setAIAttack(25);
            }
        }
        return chosenMove;
    }

    public String askUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Available moves: " + move1 + ", " + move2 + ", " + move3 + ", " + move4);
        System.out.print("Choose your move: ");
        String chosenMove = scan.nextLine();
        System.out.println("You chose: " + chosenMove);
        while (!(chosenMove.equals(move1) || chosenMove.equals(move2) || chosenMove.equals(move3) || chosenMove.equals(move4))) {
            System.out.println();
            System.out.println("Invalid move. Try again.");
            System.out.println("Available moves: " + move1 + ", " + move2 + ", " + move3 + ", " + move4);
            System.out.println();
            System.out.print("Choose your move: ");
            chosenMove = scan.nextLine();
            System.out.println("You chose: " + chosenMove);
        }
        if (chosenMove.equals(move1) || chosenMove.equals(move2) || chosenMove.equals(move3) || chosenMove.equals(move4)) {
            System.out.println("You used the move: " + chosenMove);
        }
        return chosenMove;
    }
    public String toString() {
        String returnString = "Speed: " + speed;
        return returnString;
    }
}
