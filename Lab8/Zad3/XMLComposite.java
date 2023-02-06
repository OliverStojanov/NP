package Lab8.Zad3;

import java.util.ArrayList;
import java.util.List;

public class XMLComposite extends XML{
    List<XMLComponent> componentList;
    public XMLComposite(String name) {
        super(name);
        componentList = new ArrayList<>();
    }
    public void addComponent(XMLComponent component) {
        componentList.add(component);
    }
    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(createStartTag(indent));
        sb.append("\n");
        componentList.forEach(comp -> sb.append(comp.toString(indent+1)));
        sb.append(IndentUtil.createIndent(indent)).append("</").append(tag).append(">\n");
        return sb.toString();


    }
}
