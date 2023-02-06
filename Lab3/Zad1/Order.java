package Lab3.Zad1;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class Order {

    ArrayList<OrderItem> items;
    boolean locked;

    Order(){
        items = new ArrayList<>();
        locked = false;
    }
    public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException{
        if(count>10){
            throw new ItemOutOfStockException(item);
        }
        if(locked){
            throw new OrderLockedException();
        }
        Optional<OrderItem> orderItem = items.stream()
                .filter(each -> each.getItem().getType().equals(item.getType()))
                .findFirst();
        if (orderItem.isPresent()){
            orderItem.ifPresent(oi -> oi.setCount(count));
            return;
        }

        items.add(new OrderItem(item, count));
    }

    public int getPrice() {
        int sum=0;
        for(OrderItem item : items){
            sum+= item.getPrice();
        }
        return sum;
    }

    public void displayOrder() {
        IntStream.range(0,items.size())
                .forEach(i ->{
                    OrderItem order = items.get(i);
                    System.out.printf("%3d.%-15sx%2d%5d$\n",i+1,order.getItem().getType(),order.getCount(),order.getPrice());
                });
        System.out.printf("%-22s%5d$\n", "Total:", getPrice());
    }

    public void removeItem(int idx) throws OrderLockedException{
        if(locked){
            throw new OrderLockedException();
        }
        items.remove(idx);
    }

    public void lock() throws EmptyOrder{
        if(items.size() == 0){
            throw new EmptyOrder();
        }
        locked = true;
    }
}
