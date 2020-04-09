import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestBackPack {
    @Test
    public void test() {
        int N = 5;
        int V = 10;
        int values[] = {1, 2, 3, 4, 5};
        int volumes[] = {5, 4, 3, 2, 1};
        int[][] c = BackPack.BackPack_Solution(V, N, values, volumes);
        int[][] expected = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
                {0, 5, 5, 9, 9, 9, 9, 9, 9, 9, 9},
                {0, 5, 5, 9, 9, 9, 12, 12, 12, 12, 12},
                {0, 5, 5, 9, 9, 9, 12, 12, 12, 12, 14},
                {0, 5, 5, 9, 9, 9, 12, 12, 12, 12, 14}
        };

        Assert.assertArrayEquals(expected, c);
    }


}
