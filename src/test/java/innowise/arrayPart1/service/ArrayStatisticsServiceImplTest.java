package innowise.arrayPart1.service;

import innowise.arrayPart1.entity.CustomArray;
import innowise.arrayPart1.service.impl.ArrayStatisticsServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStatisticsServiceImplTest {
    private static final int[] TEST_DATA = {3, 1, 4, 1, 5, 9};
    private final ArrayStatisticsService statisticsService = new ArrayStatisticsServiceImpl();

    @Test
    void testFindMin() {
        CustomArray array = new CustomArray(TEST_DATA);
        Optional<Integer> actual = statisticsService.findMin(array);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(1, actual.get());
    }

    @Test
    void testFindMax() {
        CustomArray array = new CustomArray(TEST_DATA);
        Optional<Integer> actual = statisticsService.findMax(array);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(9, actual.get());
    }

    @Test
    void testFindSum() {
        CustomArray array = new CustomArray(TEST_DATA);
        Optional<Integer> actual = statisticsService.findSum(array);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(23, actual.get());
    }
}