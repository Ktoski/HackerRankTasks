package ServiceLane;

import java.util.Objects;

public class TestCase {
    private int beginning;
    private int end;

    public TestCase(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    public int getBeginning() {
        return beginning;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return beginning == testCase.beginning &&
                end == testCase.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginning, end);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}
