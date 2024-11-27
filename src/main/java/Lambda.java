
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class Lambda {
    public static void main(String[] args) {
        //Task 1: filtering and transformation
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(n -> n%2==1)
                .map(n -> n*n)
                .forEach(System.out::println);


        //Task 2: String manipulation
        List<String> words = Arrays.asList("java", "stream", "api", "lambda");
        words.stream()
                .map(String::toUpperCase)
                .filter(s ->s.length() >=4)
                .sorted()
                .collect(Collectors.toList());
        words.forEach(System.out::println);


        //Task 3: Custom sorting with comparator
        List<Person> people = Arrays.asList(
                new Person("Rose", 27),
                new Person("Rachael", 25),
                new Person("Hope", 21),
                new Person("David", 19),
                new Person("Deborah", 25)
        );
        people.sort(Comparator.comparingInt(Person::getAge)
                .thenComparing(Person::getName));
        for (Person person: people){
            System.out.println(person);
        }


        //Task 4: Grouping data
        List<String> letters = Arrays.asList("orange", "books", "dog", "cat", "apple", "cherry");
        Map<Integer, List<String>> groupedByLength = letters.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);

        //Task 5: max and min
        List<Integer> number = Arrays.asList(4, 3, 10, 2,6);

        int max = Collections.max(number);
        int min = Collections.min(number);

        System.out.println("Max: " + max + ", Min: "+ min);


        //Task 6: Summing and Averaging
        List<Integer> integers= Arrays.asList(20, 30, 40, 50);

        int sum= integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        double average= integers.stream()
                .mapToInt(Integer:: intValue)
                .average()
                .orElse(0.0);
        System.out.println("Sum: "+ sum);
        System.out.println("Average: " + average);

        //Task 7: Distinct and Sorted
        List<Integer> values= Arrays.asList(6, 4, 8, 2, 6, 4, 7);

        Set<Integer> uniqueNumbers = new HashSet<>(values);
        List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);
        Collections.sort(uniqueList);
        System.out.println("Distinct and Sorted List: "+ uniqueList);

        //Task 8: Word Frequency
        List<String> characters = Arrays.asList("shoe", "laptop", "plate", "shoe", "laptop", "fish");
        Map<String, Integer> wordCountMap= new HashMap<>();
        for(String word: characters) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCountMap);

        //Task 9: Find First Match
        List<Integer> variables = Arrays.asList(3, 8, 13, 6, 15);
        Optional<Integer> firstMatch = variables.stream()
                .filter(num -> num >10)
                .findFirst();
        System.out.println(firstMatch);

        //Task 10: Parallel Streams
        List<Integer> inputs = IntStream.rangeClosed(1, 1000000)
                .boxed()
                .collect(Collectors.toList());
        long startTime = System.nanoTime();
        int sequentialSum = inputs.stream().mapToInt(Integer::intValue).sum();
        long endTime = System.nanoTime();
        long sequentialTime = endTime - startTime;

        System.out.println("Sequential stream sum: " + sequentialSum);
        System.out.println("Time taken for sequential stream: " + sequentialTime + " nanoseconds");

        startTime = System.nanoTime();
        int parallelSum = inputs.parallelStream().mapToInt(Integer::intValue).sum();
        endTime = System.nanoTime();
        long parallelTime = endTime - startTime;

        System.out.println("Parallel stream sum: " + parallelSum);
        System.out.println("Time taken for parallel stream: " + parallelTime + " nanoseconds");
        System.out.println("Speedup: " + (sequentialTime/(double) parallelTime) + " time faster for parallel stream");


    }

}
