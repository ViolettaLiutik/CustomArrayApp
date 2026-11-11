package innowise.arrayPart1.reader;

import innowise.arrayPart1.exception.ArrayException;
import java.nio.file.Path;
import java.util.List;

public interface ArrayReader {
    List<String> readFromFile(Path path) throws ArrayException;
}