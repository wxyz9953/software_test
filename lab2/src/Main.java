import cn.edu.tju.wxy.ExcelData;
import cn.edu.tju.wxy.ExcelReader;
import cn.edu.tju.wxy.Sender;
import cn.edu.tju.wxy.TestThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ExcelData> readResult = ExcelReader.readExcel();
        long current = System.currentTimeMillis();


        List<Thread> threadList = getThreadList(readResult, 4);
        for (Thread t : threadList) {
            t.start();
        }
        for (Thread t : threadList) {
            t.join();
        }


        System.out.println(System.currentTimeMillis() - current);
    }

    public static List<Thread> getThreadList(List<ExcelData> list, int threadNum) {
        List<Thread> threadList = new ArrayList<>();
        int step = 20 / threadNum;
        int i;
        for (i = 0; i < threadNum - 1; i++) {
            threadList.add(new Thread(new TestThread(list, new Sender(), i * step, (i + 1) * step)));
        }
        threadList.add(new Thread(new TestThread(list, new Sender(), i * step, 20)));
        return threadList;
    }
}
