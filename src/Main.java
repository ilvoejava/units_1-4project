import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {

        //SETUP
        String yourPoke = "";
        String AIPoke = "Mewtwo";
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to Pokemon Battle Simulator! \nChoose your starter (Venusaur, Charizard, Blastoise, Mewtwo, or Magikarp): ");
        yourPoke = scan.nextLine();
        while (yourPoke.equals("Mewtwo") || !(yourPoke.equals("Venusaur")) || !(yourPoke.equals("Charizard")) || !(yourPoke.equals("Blastoise")) || !(yourPoke.equals("Magikarp"))) {
            if (yourPoke.equals("Venusaur")) {
                AIPoke = "Charizard";
                break;
            } else if (yourPoke.equals("Charizard")) {
                AIPoke = "Blastoise";
                break;
            } else if (yourPoke.equals("Blastoise")) {
                AIPoke = "Venusaur";
                break;
            } else if (yourPoke.equals("Mewtwo")) {
                System.out.println("Mewtwo broke the game. Please try again.");
            } else if (yourPoke.equals("Magikarp")) {
                System.out.println("Magikarp is god, so you win the game.");
                System.exit(0);
            } else {
                System.out.println(yourPoke + " is not a valid Pokemon. Please try again.");
            }
            yourPoke = scan.nextLine();
        }
        System.out.println("You chose " + yourPoke + "!");
        System.out.println("Your opponent chose " + AIPoke + "!");

        Pokemon myPokemon = new Pokemon(100, 20, 10, 2);
        Pokemon AiPokemon = new Pokemon(100, 20, 10, 1000);
        if (yourPoke.equals("Venusaur")) {
            myPokemon.increaseHealth(20);
            myPokemon.decreaseAttack(5);
            AiPokemon.increaseAttack(20);
            AiPokemon.decreaseDefense(5);
        } else if (yourPoke.equals("Charizard")) {
            myPokemon.increaseAttack(20);
            myPokemon.decreaseDefense(5);
            AiPokemon.increaseDefense(10);
            AiPokemon.decreaseHealth(10);
        } else if (yourPoke.equals("Blastoise")) {
            myPokemon.increaseDefense(10);
            myPokemon.increaseHealth(10);
            AiPokemon.increaseHealth(20);
            AiPokemon.decreaseAttack(5);
        }
        System.out.println("Your Pokemon's " + myPokemon.toString());



        //MOVE CHOICE
        while (myPokemon.getHealth() > 0 && AiPokemon.getHealth() > 0) {
            myPokemon.moves(yourPoke);
            AiPokemon.moves(AIPoke);
            System.out.println();
            System.out.println("Your Pokemon's HP: " + myPokemon.getHealth() + "!" + "\nYour opponent's Pokemon has " + AiPokemon.getHealth() + " HP!");
            System.out.println();



            //BATTLE
            if (yourPoke.equals("Charizard")) {
                myPokemon.CharizardStats(myPokemon.askUser());
            } else if (yourPoke.equals("Blastoise")) {
                myPokemon.BlastoiseStats(myPokemon.askUser());
            } else {
                myPokemon.VenusaurStats(myPokemon.askUser());
            }

            double total = myPokemon.dice();
            int yourDmg = (int) (myPokemon.getAttack() * total - AiPokemon.getDefense());
            if (yourDmg < 0) {
                yourDmg = 0;
            }
            int health = myPokemon.getHealth();
            if (health > myPokemon.getMaxHealth()) {
                health = myPokemon.getMaxHealth();
            }
            System.out.println("Your attack dealt " + yourDmg + " damage!");
            AiPokemon.decreaseHealth((int) yourDmg);


            if (AIPoke.equals("Charizard")) {
                AiPokemon.CharizardStats(AiPokemon.AImove(AIPoke));
            } else if (AIPoke.equals("Blastoise")) {
                AiPokemon.BlastoiseStats(AiPokemon.AImove(AIPoke));
            } else {
                AiPokemon.VenusaurStats(AiPokemon.AImove(AIPoke));
            }

            double total2 = AiPokemon.dice();
            int AIDmg = (int) (AiPokemon.getAIAttack() * total2 - myPokemon.getDefense());
            if (AIDmg < 0) {
                AIDmg = 0;
            }
            health = AiPokemon.getHealth();
            if (health > AiPokemon.getMaxHealth()) {
                health = AiPokemon.getMaxHealth();
            }
            String opponentMove = AiPokemon.AImove(AIPoke);
            System.out.println();
            System.out.println("Your opponent used the move: " + opponentMove);
            System.out.println("Your opponent's attack dealt " + AIDmg + " damage!");
            myPokemon.decreaseHealth((int) AIDmg);
        }



        //END PHASE
        if (myPokemon.getHealth() < 0 || AiPokemon.getHealth() < 0) {
            if (myPokemon.getHealth() < 0) {
                System.out.println("Your pokemon fainted. You lost.");
            } else if (myPokemon.getHealth() < 0 && AiPokemon.getHealth() < 0) {
                System.out.println("Your pokemons both fainted at the same time. It's a draw");
            } else {
                System.out.println("Your enemy's pokemon fainted. You win!!!!!!!!!!");
            }
        }
    }
}