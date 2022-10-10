import java.util.Scanner;

public class Player extends Person {
    private static Scanner sc = new Scanner(System.in);
    private String res = "";
    private String name;

    public Player(String name) {
        super(name);
        this.name = name;
        // System.out.println(name + "'s cards: ");
        // for (int i = 0; i < this.getHand().getHand().size(); i++) {
        // // System.out.println("Value while adding cards: " + value);
        // System.out.print(this.getHand().getHand().get(i).displayCard() + ", ");

        // if (this.getHand().getHand().get(i).getRank().equals("Ace")) {
        // if (getHandValue() + 10 < 22) {
        // hand.setVal(getHandValue() + 10);
        // System.out.println(getHandValue());
        // }
        // }
        // }
        // System.out.print("Total value: " + this.getHandValue());
    }

    public void runFunctions() {
        // while (!checkGameOver()) {
        System.out.print("Your cards: ");
        for (int i = 0; i < this.getHand().getHand().size(); i++) {
            // System.out.println("Value while adding cards: " + value);
            System.out.print(this.getHand().getHand().get(i).displayCard() + ", ");
            if (this.getHand().getHand().get(i).getRank().equals("Ace")) {
                if (getHandValue() + 10 < 22) {
                    hand.setVal(getHandValue() + 10);
                    System.out.println(getHandValue());
                }
            }
        }
        System.out.print("Total value: " + this.getHandValue());
        System.out.println("");
        System.out.print("Do you (" + this.name + ") want to hit or stand? ");
        String decision = sc.nextLine();
        res = decision;
        if (decision.equals("hit")) {
            this.addCardToHand();
            if (hand.getHand().get(hand.getHand().size() - 1).getRank().equals("Ace")) {
                System.out.println("You got an ace!");
                System.out.print(
                        "Do you want the ace to be of value 11? Type y for yes. ");
                String answ = sc.nextLine();
                if (answ.equals("yes")) {
                    int change = getHandValue() + 10;
                    hand.setVal(change);
                } else {

                }
            }
        }

        // }
    }

    public String getResponse() {
        return this.res;
    }

    public String getName() {
        return this.name;
    }
}
