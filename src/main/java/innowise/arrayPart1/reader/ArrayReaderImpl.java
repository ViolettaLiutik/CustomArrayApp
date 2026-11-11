package innowise.arrayPart1.reader;

import innowise.arrayPart1.exception.ArrayException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    @Override
    public List<String> readFromFile(Path path) throws ArrayException {
        List<String> lines;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArrayException("Error reading file: " + path, e);
        }
        return lines;
    }
}