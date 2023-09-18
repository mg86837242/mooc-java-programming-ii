import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.stream().forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    public int totalValue() {
        return cards
                .stream()
                .map(card -> card.getValue())
                .reduce(0, (acc, cv) -> acc + cv);
    }

    @Override
    public int compareTo(Hand other) {
        return totalValue() - other.totalValue();
    }
}
