package innowise.arrayPart1.factory;

import innowise.arrayPart1.entity.CustomArray;

public interface ArrayFactory {
    CustomArray createInstance(int[] values);
}