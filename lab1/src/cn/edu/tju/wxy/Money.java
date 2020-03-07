package cn.ecu.tju.wxy;


public class Money {

    public boolean judge(int x) {
        int[] m = {50, 20, 10, 5, 5, 1, 1, 1};
        if (x == 0) return true;
        for (int value : m) {
            x -= value;
            if (x < 0) x += value;
            if (x == 0) return true;
        }
        return false;
    }


}
