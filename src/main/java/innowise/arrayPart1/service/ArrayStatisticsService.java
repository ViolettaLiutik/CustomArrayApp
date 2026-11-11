package innowise.arrayPart1.service;

import innowise.arrayPart1.entity.CustomArray;
import java.util.Optional;

public interface ArrayStatisticsService {
    Optional<Integer> findMin(CustomArray array);
    Optional<Integer> findMax(CustomArray array);
    Optional<Integer> findSum(CustomArray array);
    Optional<Double> findAverage(CustomArray array);
}