public class Dealer extends Person {
    private boolean over = false;
    private boolean stands = false;

    public Dealer(String name) {
        super(name);
        /// System.out.println("");
        System.out.println("Dealer's first card: " + getHand().getHand().get(0).displayCard() + ", ");
    }

    public boolean stands() {
        return stands;
    }

    public void runFunctions() {
        while (!over) {
            System.out.println();
            if (getHandValue() < 17) {
                System.out.println("Dealer hit: ");

                addCardToHand();
                for (int i = 0; i < getHand().getHand().size(); i++) {
                    System.out.print(getHand().getHand().get(i).displayCard() + ", ");
                }
                System.out.print("Total value: " + this.getHandValue());
            } else {
                System.out.println("Dealer stands with cards:");
                stands = true;
                for (int i = 0; i < getHand().getHand().size(); i++) {
                    System.out.print(getHand().getHand().get(i).displayCard() + ", ");
                }
                System.out.print("Total value: " + this.getHandValue());
                over = true;
            }
        }
    }
}
