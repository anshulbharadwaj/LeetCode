package thread;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOptions {
    private static String HOME = System.getProperty("user.home");

    @Test
    void test() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        Path path = Paths.get(HOME + separator + "Documents","testFile.txt");
        Files.write(path,"DummyTest".getBytes(), StandardOpenOption.SYNC);
    }


}
