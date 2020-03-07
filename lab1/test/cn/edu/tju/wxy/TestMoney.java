package cn.edu.tju.wxy;

import static org.junit.Assert.*;

import cn.ecu.tju.wxy.Money;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class TestMoney {

    private Money money;
    private int x;

    public TestMoney(int x) {
        this.x = x;
    }

    @Before
    public void setup() {
        money = new Money();
    }

    @Parameters
    public static Collection getData() {

        int[] coins = {50, 20, 10, 5, 5, 1, 1, 1};
        Set<Integer> set = new HashSet<>();
        data(coins, set);
        return Arrays.asList(set.toArray());
    }

    @Test
    public void test() {
        assertTrue(money.judge(x));
    }

    private static void data(int[] coins, Set<Integer> set) {
        int nCnt = coins.length;
        int nBit = 1 << nCnt;
        for (int i = 1; i <= nBit; i++) {
            int sum = 0;
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    sum += coins[j];
                }
            }
            set.add(sum);
        }
    }

}
