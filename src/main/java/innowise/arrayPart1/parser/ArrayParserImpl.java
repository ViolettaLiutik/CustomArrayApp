package innowise.arrayPart1.parser;

import innowise.arrayPart1.exception.ArrayException;
import innowise.arrayPart1.validator.ArrayValidator;

public class ArrayParserImpl implements ArrayParser {
    private static final String DELIMITER = ",";
    private final ArrayValidator validator;

    public ArrayParserImpl(ArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public int[] parseLine(String line) throws ArrayException {
        int[] result;
        if (!validator.isValidLine(line)) {
            throw new ArrayException("Invalid line data: " + line);
        }
        String[] tokens = line.split(DELIMITER);
        result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].strip();
            result[i] = Integer.parseInt(token);
        }
        return result;
    }
}