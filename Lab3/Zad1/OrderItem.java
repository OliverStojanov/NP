package Lab3.Zad1;

public class OrderItem {
    private Item item;
    private int count;

    public OrderItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getPrice(){
        return item.getPrice() * count;
    }
}
