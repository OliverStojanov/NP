package Lab3.Zad1;

public class PizzaItem implements Item{
    PizzaType type;
    PizzaItem(String type) throws InvalidPizzaTypeException{
        try{
            this.type = PizzaType.valueOf(type);
        }catch (IllegalArgumentException e){
            throw new InvalidPizzaTypeException(type);
        }
    }
    @Override
    public int getPrice() {
        return type.getCost();
    }

    public String getType(){
        return type.name();
    }
}
