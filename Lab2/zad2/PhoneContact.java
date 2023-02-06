package Lab2.zad2;

public class PhoneContact extends Contact{
    String phone;
    Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String toString(){
        return '\"' + phone + '\"';
    }

    @Override
    public String getType() {
        return "Phone";
    }
    public Operator getOperator() {
        String br = phone.substring(0,3);
        if (br.equals("070")||br.equals("071")||br.equals("072")){
            return operator.TMOBILE;
        } else if (br.equals("075")||br.equals("076")) {
            return Operator.ONE;
        } else if (br.equals("077")||br.equals("078")) {
            return Operator.VIP;
        }
        return null;
    }
}
