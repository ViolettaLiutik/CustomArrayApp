package innowise.arrayPart1.parser;

import innowise.arrayPart1.exception.ArrayException;

public interface ArrayParser {
    int[] parseLine(String line) throws ArrayException;
}