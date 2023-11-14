import java.util.*;
import java.util.stream.Collectors;

public class DemoOne {
    public static void main(String[] args) {
        final List<String> words = Arrays.asList("abc", "an", "", "apple", "bcd", "", "jk");
        final Map<String,Integer> counts = new HashMap<>();
        counts.put("startsWitha",0);
        counts.put("empty",0);
        final String upperCase = words.stream().map(word->{
            if ("".equals(word)){
                counts.put("empty", counts.get("empty")+1);
            } else if(word.startsWith("a")){
                counts.put("startsWitha", counts.get("startsWitha")+1);     
            }
            return word.toUpperCase(Locale.ENGLISH);
        }).filter(word->!word.isEmpty()).collect(Collectors.joining(","));

        System.out.printf("Number of strings that start with 'a' are %d\n",counts.get("startsWitha"));
        System.out.printf("Number of empty strings are %d\n",counts.get("empty"));
        System.out.printf("UpperCase String is %s\n", upperCase);
    }
}
