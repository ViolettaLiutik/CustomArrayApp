package innowise.arrayPart1.service.impl;

import innowise.arrayPart1.entity.CustomArray;
import innowise.arrayPart1.service.ArraySortingService;

public class ArraySortingServiceImpl implements ArraySortingService {
    @Override
    public void bubbleSort(CustomArray array) {
        if (array != null) {
            int[] nums = array.getElements();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            array.setElements(nums);
        }
    }

    @Override
    public void selectionSort(CustomArray array) {
        if (array != null) {
            int[] nums = array.getElements();
            for (int i = 0; i < nums.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
            array.setElements(nums);
        }
    }
}