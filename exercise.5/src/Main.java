import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String [] myArray = {"FirstWord", "SecondWord", "THIRDWORD", "FourThWorD"};

        System.out.println(Stream.of(myArray)
                .map(String::toLowerCase)
                .collect(Collectors.joining(" ")));

    }
}