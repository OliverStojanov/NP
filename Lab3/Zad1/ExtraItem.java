package Lab3.Zad1;

public class ExtraItem implements Item{
    private ExtraType type;
    ExtraItem(String type) throws InvalidExtraTypeException{
        try{
            this.type = ExtraType.valueOf(type);
        }catch (IllegalArgumentException e){
            throw new InvalidExtraTypeException(type);
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
