package innowise.arrayPart1.action;

import innowise.arrayPart1.entity.CustomArray;
import innowise.arrayPart1.exception.ArrayException;
import innowise.arrayPart1.factory.ArrayFactory;
import innowise.arrayPart1.factory.ArrayFactoryImpl;
import innowise.arrayPart1.parser.ArrayParser;
import innowise.arrayPart1.parser.ArrayParserImpl;
import innowise.arrayPart1.reader.ArrayReader;
import innowise.arrayPart1.reader.ArrayReaderImpl;
import innowise.arrayPart1.service.ArraySortingService;
import innowise.arrayPart1.service.ArrayStatisticsService;
import innowise.arrayPart1.service.impl.ArraySortingServiceImpl;
import innowise.arrayPart1.service.impl.ArrayStatisticsServiceImpl;
import innowise.arrayPart1.validator.ArrayValidator;
import innowise.arrayPart1.validator.ArrayValidatorImpl;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "data/arrays.txt";

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl(validator);
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayStatisticsService statisticsService = new ArrayStatisticsServiceImpl();
        ArraySortingService sortingService = new ArraySortingServiceImpl();

        try {
            Path path = Path.of(FILE_PATH);
            List<String> lines = reader.readFromFile(path);
            for (String line : lines) {
                try {
                    int[] parsedValues = parser.parseLine(line);
                    CustomArray customArray = factory.createInstance(parsedValues);
                    logger.info("Loaded array: {}", customArray);

                    Optional<Integer> min = statisticsService.findMin(customArray);
                    Optional<Integer> max = statisticsService.findMax(customArray);
                    Optional<Integer> sum = statisticsService.findSum(customArray);
                    Optional<Double> avg = statisticsService.findAverage(customArray);

                    logger.info("Stats -> Min: {}, Max: {}, Sum: {}, Avg: {}", min.orElse(null), max.orElse(null), sum.orElse(null), avg.orElse(null));

                    sortingService.bubbleSort(customArray);
                    logger.info("Bubble sorted: {}", customArray);

                } catch (ArrayException e) {
                    logger.warn("Skipped invalid line [{}] due to: {}", line, e.getMessage());
                }
            }
        } catch (ArrayException e) {
            logger.error("Fatal application error: {}", e.getMessage(), e);
        }
    }
}