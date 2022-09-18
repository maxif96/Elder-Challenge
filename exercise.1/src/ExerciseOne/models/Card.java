package ExerciseOne.models;

import ExerciseOne.enumerations.Brand;

import java.time.LocalDate;
import java.util.Objects;

public class Card {

    private Brand brand;
    private Long cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;

    //No args constructor

    public Card() {}

    //All args constructor

    public Card(Brand brand, Long cardNumber, String cardHolder, LocalDate expirationDate) {
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    //Getters & Setters

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    //Equals & Hash Code

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }


    //To String

    @Override
    public String toString() {
        return "\n--- Card Information ---" +
                "\nBrand: " + brand +
                " \nCardholder: " + cardHolder +
                " \nCard Number: " + cardNumber +
                " \nExpiration Date: " + expirationDate;
    }
}
