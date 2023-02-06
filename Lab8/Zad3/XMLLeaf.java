package Lab8.Zad3;

public class XMLLeaf extends XML {

    String element;
    public XMLLeaf(String tag, String element) {
        super(tag);
        this.element = element;
    }

    @Override
    public String toString(int indent) {
        return createStartTag(indent) + element + "</" + tag + ">\n";
    }


}
