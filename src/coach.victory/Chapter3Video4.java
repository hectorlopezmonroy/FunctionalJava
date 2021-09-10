package coach.victory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Video4 {

  public static void main(String[] args) {
    String[] wordsArr = {"hello", "functional", "functional", "programmming", "is", "cool"};
    List<String> words = new ArrayList<>(Arrays.asList(wordsArr));
    Predicate<String> lengthIsGreaterThan5 = word -> word.length() > 5;

    List<String> longWordsList = words
        .stream()
        .filter(lengthIsGreaterThan5)
        .collect(Collectors.toList());
    System.out.println("Collectors.toList()                                 longWordsList:        " + longWordsList);

    Set<String> longWordsSet = words
        .stream()
        .filter(lengthIsGreaterThan5)
        .collect(Collectors.toSet());
    System.out.println("Collectors.toSet()                                  longWordsSet:         " + longWordsSet);

    String longWordsJoined = words
        .stream()
        .filter(lengthIsGreaterThan5)
        .collect(Collectors.joining(", "));
    System.out.println("Collectors.joining(\", \")                            longWordsJoined:      " + longWordsJoined);

    Long howManyLongWords = words
        .stream()
        .filter(lengthIsGreaterThan5)
        .collect(Collectors.counting());
    System.out.println("Collectors.counting()                               howManyLongWords:     " + howManyLongWords);

    Map<Integer, List<String>> wordLengthMap = words
        .stream()
        .collect(Collectors.groupingBy(word -> word.length()));
    System.out.println("Collectors.groupingBy(word -> word.length())        wordLengthMap:        " + wordLengthMap);

    Map<Boolean, List<String>> wordLengthPartitions = words
        .stream()
        .collect(Collectors.partitioningBy(lengthIsGreaterThan5));
    System.out.println("Collectors.partitioningBy(word -> word.length > 5)  wordLengthPartition:  " + wordLengthPartitions);
  }
}
