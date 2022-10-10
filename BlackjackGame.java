import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    private static boolean allgameOver = false;
    private static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (players.size() == 0) {
                System.out.print("Name of player: ");
                String name = sc.nextLine();
                Player player = new Player(name);
                players.add(player);
            } else {
                System.out.println();
                System.out.print("Type s to start or name of another player: ");
                String response = sc.nextLine();
                if (response.equals("s")) {
                    break;
                }
                Player player = new Player(response);
                players.add(player);
            }
        }
        Dealer dealer = new Dealer("Dealer");
        // System.out.println(player.getHand());
        // System.out.println(dealer.getHand());
        while (!allgameOver) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getHandValue() == 21) {
                    System.out.println("Blackjack on first try for " + players.get(i).getName() + "!!!!");
                    players.remove(players.get(i));
                    continue;
                }
                players.get(i).runFunctions();

                if (checkGameOver(players.get(i), dealer)) {
                    players.remove(players.get(i));
                }
            }

            int counter = 0;
            int standcount = 0;
            for (int j = 0; j < players.size(); j++) {
                if (checkGameOver(players.get(j), dealer)) {
                    counter++;

                }
                if (players.get(j).getResponse().equals("stand")) {
                    standcount++;
                }
            }

            if (counter == players.size() || dealer.getHandValue() > 21) {

                allgameOver = true;
            }
            if (standcount == players.size()) {
                dealer.runFunctions();
                for (int i = 0; i < players.size(); i++) {
                    checkGameOver(players.get(i), dealer);

                }
                allgameOver = true;
            }

        }
        sc.close();
    }

    public static boolean checkGameOver(Player player, Dealer dealer) {
        // System.out.println("Player hand vlaue: " + player.getHandValue());
        // System.out.println("Player hand: " + player.getHand());
        // System.out.println("Dealer hand: " + dealer.getHand());

        if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
            System.out.println();
            System.out.println("Blackjack for " + player.getName() + "!!!");
            return true;
        } else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
            System.out.println();

            System.out.println("You (" + player.getName() + ") and the dealer tied with value of 21!");
            return true;
        } else if (player.getHandValue() > 21) {
            System.out.println();

            System.out.println("You (" + player.getName() + ") lost with a value of " + player.getHandValue() + "!!!!");
            return true;
        } else if (dealer.getHandValue() > 21) {
            System.out.println();
            System.out.println("You (" + player.getName() + ") won!!");
            return true;
        } else if (dealer.getHandValue() == 21) {
            System.out.println();
            System.out.println("You (" + player.getName() + ") just got blackjacked by the dealer.");
            return true;
        } else if (dealer.getHandValue() == player.getHandValue()) {
            System.out.println();
            System.out.println("It's a tie between dealer and " + player.getName());
            return true;
        }
        if (dealer.stands()) {
            System.out.println();
            if (player.getHandValue() > dealer.getHandValue()) {
                System.out.println(
                        "You (" + player.getName() + ") won! " + player.getHandValue() + " > " + dealer.getHandValue());
            } else {
                System.out.println("You (" + player.getName() + ") lost! " + player.getHandValue() + " < "
                        + dealer.getHandValue());

            }
            return true;
        }
        return false;
    }

}
