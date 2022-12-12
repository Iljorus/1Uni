package Blatt8;

import myUtils.logger.*;

public class Main {
    public static void main(String[] args) {
        Logger log=new Logger(new Main(), false);
        log.file("test", InfoType.INFO);
    }
}
