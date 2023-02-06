package Lab8.Zad3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class XML implements XMLComponent{

    Map<String,String> attributes;
    String tag;

    public XML(String tag) {
        this.tag = tag;
        attributes = new LinkedHashMap<>();
    }

    @Override
    public void addAttribute(String name, String value) {
        attributes.put(name,value);
    }

    public String createStartTag(int indent){
        StringBuilder sb = new StringBuilder();
        sb.append(IndentUtil.createIndent(indent));
        sb.append("<").append(tag);
        if(!attributes.isEmpty()){
            sb.append(" ");
            sb.append(attributes.entrySet().stream()
                    .map(this::createStringForAttributes)
                    .collect(Collectors.joining(" ")));
        }
        sb.append(">");
        return  sb.toString();
    }

    private String createStringForAttributes(Map.Entry<String, String> stringStringEntry) {
        return String.format("%s=\"%s\"", stringStringEntry.getKey(), stringStringEntry.getValue());
    }

}
