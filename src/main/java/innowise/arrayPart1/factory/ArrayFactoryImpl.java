package innowise.arrayPart1.factory;

import innowise.arrayPart1.entity.CustomArray;

public class ArrayFactoryImpl implements ArrayFactory {
    @Override
    public CustomArray createInstance(int[] values) {
        return new CustomArray(values);
    }
}