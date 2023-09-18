public class Container {

  int amount;

  public Container() {
    this.amount = 0;
  }

  public int contains() {
    return amount;
  }

  public void add(int addAmt) {
    if (addAmt > 0) {
      amount = Math.min(amount + addAmt, 100);
    }
  }

  public void remove(int removeAmt) {
    if (removeAmt > 0) {
      amount = Math.max(amount - removeAmt, 0);
    }
  }

  @Override
  public String toString() {
    return amount + "/100";
  }
}
