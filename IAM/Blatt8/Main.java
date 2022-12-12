package Blatt8;

import myUtils.logger.*;
import myUtils.userInput.*;

public class Main {
    public static void main(String[] args) {
        Logger log=new Logger(new Main(), false);
        log.file("test", InfoType.INFO);
    }
}
