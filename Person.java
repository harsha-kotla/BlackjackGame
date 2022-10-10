public class Person {
    private String name;
    // private int wins;
    protected Hand hand = new Hand();

    public Person(String name) {
        this.name = name;
    }

    public void addCardToHand() {
        hand.addNewCard();

    }

    public int getHandValue() {
        return hand.getHandValue();
    }

    public Hand getHand() {
        return hand;
    }
}
