package edu.fiuba.algo3.modelo;

public class Logger {

    private static Logger log;
    private static Boolean enableLog = false;

    public static void log(String log) {
        if (enableLog) {
            System.out.println(log);
        }
    }

    public static void setEnableLog(Boolean value) {
        enableLog = value;
    }

    public static Logger getInstance() {
        if (log == null){
            log = new Logger();
        }
        return log;
    }

}
