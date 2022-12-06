package edu.fiuba.algo3.modelo.Views;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorDeSonidos {

    private Media extraerSonido(String directorioDelArchivo) {
        //return new Media(getClass().getClassLoader().getResource(directorioDelArchivo).toExternalForm());
        try {
            return new Media(getClass().getResource(directorioDelArchivo).toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new Media("");
        }
    }

    public void reproducirSonido(String directorioDelArchivo) {
        /*
        System.out.print(new File(directorioDelArchivo));
        System.out.print(new File(directorioDelArchivo).toURI());
        System.out.print(new File(directorioDelArchivo).toURI().toString());
        Media sonido = new Media(new File(directorioDelArchivo).toURI()..toString());
        reproducirSonido(sonido);*/

/*
        
        Media sonido;
        try {
            sonido = new Media(new File(directorioDelArchivo).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            return;
        }

*/
        //Media sonido2 = new ReproductorDeSonidos().extraerSonido(directorioDelArchivo);
        this.extraerSonido(directorioDelArchivo);
        reproducirSonido(this.extraerSonido(directorioDelArchivo));
    }

    public void reproducirSonido(Media sonido) {
        MediaPlayer control = new MediaPlayer(sonido);
        control.setCycleCount(MediaPlayer.INDEFINITE);
        control.setAutoPlay(true);
    }

}