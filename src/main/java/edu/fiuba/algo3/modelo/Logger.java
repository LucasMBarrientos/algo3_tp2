package edu.fiuba.algo3.modelo;

public class Logger {

    static Logger log;
    public static Boolean enableLog = false;

    private Logger (){

    }
    public static void log(String log){
        if(enableLog){
            System.out.println(log);
        }
    }

    public static void setEnableLog(Boolean value){
        enableLog = value;
    }

    public static Logger getInstance(){
        if (log == null){
            log = new Logger();
        }
        return log;
    }
}
