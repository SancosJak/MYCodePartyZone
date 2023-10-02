package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesReadParallel_Stream {

    public static void main(String[] args) throws IOException {

        String filePath1 = "HomeWorks/lesson58/l58hw/code/file1.txt";
        String filePath2 = "HomeWorks/lesson58/l58hw/code/file2.txt";

        Stream<String> lines1 = Files.lines(Paths.get(filePath1));
        Stream<String> lines2 = Files.lines(Paths.get(filePath2));
        Stream<String> mixesStream = Stream.concat(lines1, lines2);

        mixesStream.parallel().forEach(line -> System.out.print(line + " "));

        lines1.close();
        lines2.close();
    }
}
