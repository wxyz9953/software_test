import org.junit.Assert;
import org.junit.Test;

public class TestBubbleSort {

    @Test
    public void test() {
        int arr1[] = {2, 2, 3, 5, -1, 3, 2};
        int res1[] = {-1, 2, 2, 2, 3, 3, 5};
        Assert.assertArrayEquals(BubbleSort.BubbleSort(arr1), res1);
    }
}