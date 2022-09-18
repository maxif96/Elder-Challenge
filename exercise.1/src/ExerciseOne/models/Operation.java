package ExerciseOne.models;

public class Operation {

    private Card card;
    private Double amount;

    //No args constructor

    public Operation() {}

    //All args constructor

    public Operation(Card card, Double amount) {
        this.card = card;
        this.amount = amount;
    }

    //Getters & Setters

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
