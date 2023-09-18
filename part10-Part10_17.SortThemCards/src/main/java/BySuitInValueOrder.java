import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        return c1.getSuit().ordinal() - c2.getSuit().ordinal() != 0
                ? c1.getSuit().ordinal() - c2.getSuit().ordinal()
                : c1.getValue() - c2.getValue();
    }
}
