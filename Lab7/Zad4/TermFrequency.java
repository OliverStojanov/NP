package Lab7.Zad4;

import java.io.InputStream;
import java.util.*;

public class TermFrequency {
    Map<String,Integer> frequency;
    Set<String> stop;
    public TermFrequency(InputStream in, String[] stopWords) {
        frequency = new TreeMap<>();
        stop = new HashSet<>();
        for (String w : stopWords){
            stop.add(w);
        }
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            line = line.trim();
            if(line.length()>0){
                String[] words = line.split(" ");
                for(String word: words){
                    String key = normalize(word);
                    if(key.isEmpty() || stop.contains(key))
                        continue;
                    if(frequency.containsKey(key)){
                        Integer count = frequency.get(key);
                        frequency.put(key,count+1);
                    }else
                        frequency.put(key,1);
                }
            }
        }
        scanner.close();
    }
    private static String normalize(String word) {
        return word.toLowerCase().replace(",", "").replace(".", "").trim();
    }
    public int countTotal() {
        int total = 0;
        for(int count : frequency.values()){
            total+=count;
        }
        return total;
    }

    public int countDistinct() {
        return  frequency.keySet().size();
    }

    public List<String> mostOften(int i) {
        List<String> lista = new ArrayList<>();
        SortedSet<Map.Entry<String,Integer>> sorted = entriesSortedByValues(frequency);
        for(Map.Entry<String,Integer> entry: sorted){
            lista.add(entry.getKey());
            --i;
            if(i==0)
                break;
        }
        return lista;
    }

    static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                        int res = o1.getValue().compareTo(o2.getValue());
                        return res!=0? -res : 1;
                    }
                });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
