package innowise.arrayPart1.service.impl;

import innowise.arrayPart1.entity.CustomArray;
import innowise.arrayPart1.service.ArrayStatisticsService;
import java.util.Optional;

public class ArrayStatisticsServiceImpl implements ArrayStatisticsService {
    @Override
    public Optional<Integer> findMin(CustomArray array) {
        Optional<Integer> result;
        if (array == null || array.getElements().length == 0) {
            result = Optional.empty();
        } else {
            int[] elements = array.getElements();
            int min = elements[0];
            for (int i = 1; i < elements.length; i++) {
                if (elements[i] < min) {
                    min = elements[i];
                }
            }
            result = Optional.of(min);
        }
        return result;
    }

    @Override
    public Optional<Integer> findMax(CustomArray array) {
        Optional<Integer> result;
        if (array == null || array.getElements().length == 0) {
            result = Optional.empty();
        } else {
            int[] elements = array.getElements();
            int max = elements[0];
            for (int i = 1; i < elements.length; i++) {
                if (elements[i] > max) {
                    max = elements[i];
                }
            }
            result = Optional.of(max);
        }
        return result;
    }

    @Override
    public Optional<Integer> findSum(CustomArray array) {
        Optional<Integer> result;
        if (array == null || array.getElements().length == 0) {
            result = Optional.empty();
        } else {
            int[] elements = array.getElements();
            int sum = 0;
            for (int element : elements) {
                sum += element;
            }
            result = Optional.of(sum);
        }
        return result;
    }

    @Override
    public Optional<Double> findAverage(CustomArray array) {
        Optional<Integer> sumOpt = findSum(array);
        Optional<Double> result;
        if (sumOpt.isEmpty()) {
            result = Optional.empty();
        } else {
            int[] elements = array.getElements();
            double average = (double) sumOpt.get() / elements.length;
            result = Optional.of(average);
        }
        return result;
    }
}