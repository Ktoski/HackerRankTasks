package BinaryTree;

import java.util.Arrays;

public class UniquePath {

    private int[] values;

    public UniquePath(int[] values, int pathLen) {
        this.values = new int[pathLen];
        System.arraycopy(values, 0,  this.values, 0, pathLen);
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniquePath that = (UniquePath) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "UniquePath{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
