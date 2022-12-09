package edu.fiuba.algo3.modelo;

public class Logger {

    static Logger log;

    private Logger (){

    }
    public static void log(String log){
        System.out.println(log);
    }

    public static Logger getInstance(){
        if (log == null){
            log = new Logger();
        }
        return log;
    }
}
