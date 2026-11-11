package innowise.arrayPart1.validator;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final String DELIMITER = ",";

    @Override
    public boolean isValidLine(String line) {
        boolean isValid;
        if (line == null || line.isBlank()) {
            isValid = false;
        } else {
            String[] tokens = line.split(DELIMITER);
            if (tokens.length == 0) {
                isValid = false;
            } else {
                boolean allTokensAreValid = true;
                for (int i = 0; i < tokens.length; i++) {
                    String token = tokens[i].strip();
                    try {
                        Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        allTokensAreValid = false;
                        break;
                    }
                }
                isValid = allTokensAreValid;
            }
        }
        return isValid;
    }
}