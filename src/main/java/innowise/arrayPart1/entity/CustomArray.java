package innowise.arrayPart1.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] elements;

    public CustomArray(int[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public int[] getElements() {
        return Arrays.copyOf(elements, elements.length);
    }

    public void setElements(int[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual;
        if (this == o) {
            isEqual = true;
        } else if (o == null || getClass() != o.getClass()) {
            isEqual = false;
        } else {
            CustomArray that = (CustomArray) o;
            if (this.elements == that.elements) {
                isEqual = true;
            } else if (this.elements == null || that.elements == null) {
                isEqual = false;
            } else if (this.elements.length != that.elements.length) {
                isEqual = false;
            } else {
                boolean matches = true;
                for (int i = 0; i < this.elements.length; i++) {
                    if (this.elements[i] != that.elements[i]) {
                        matches = false;
                        break;
                    }
                }
                isEqual = matches;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        int customResult = 1;
        if (elements != null) {
            for (int element : elements) {
                customResult = 31 * customResult + element;
            }
        }
        return customResult;
    }

    @Override
    public String toString() {
        return "CustomArray{elements=" + Arrays.toString(elements) + '}';
    }
}