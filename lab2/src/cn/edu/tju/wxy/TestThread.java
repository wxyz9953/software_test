package cn.edu.tju.wxy;

import java.util.List;

public class TestThread implements Runnable {

    private List<ExcelData> list;
    private Sender sender;
    private int start;
    private int end;


    public TestThread(List<ExcelData> list, Sender sender, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
        this.sender = sender;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            String user = list.get(i).getUser();
            String pass = list.get(i).getPassword();
            if (sender.getResponseMessage(user, pass).equals(pass)) {
                System.out.println(Thread.currentThread().getName() + ": " + user + " ok");
            } else {
                System.out.println(Thread.currentThread().getName() + ": " + user + " wrong");
            }
        }
    }
}
