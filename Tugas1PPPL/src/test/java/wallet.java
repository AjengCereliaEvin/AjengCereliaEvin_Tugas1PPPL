import java.util.ArrayList;
import java.util.List;

public class wallet {

    private String owner;
    private List<Card> cards;
    private int cash;

    public wallet(String owner) {
        this.owner = owner;
        this.cards = new ArrayList<>();
        this.cash = 0;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public void addCash(int amount) {
        if (amount > 0) {
            this.cash += amount;
        }
    }

    public int withdrawCash(int amount) {
        if (amount > 0 && amount <= this.cash) {
            this.cash -= amount;
            return amount;
        } else {
            return 0;
        }
    }

    public int getBalance() {
        return this.cash;
    }

    @Override
    public String toString() {
        return "Dompet milik " + owner + "\nKartu: " + cards + "\nUang: " + cash;
    }

    public String getOwner() {
        return owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}

class Card {

    private String type;
    private String number;

    public Card(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return type + " - " + number;
    }
}