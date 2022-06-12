package org.gyula.concurrencyInJavaThreadsSourcecode;

import static org.gyula.concurrencyInJavaThreadsSourcecode.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread.");
    }
}
