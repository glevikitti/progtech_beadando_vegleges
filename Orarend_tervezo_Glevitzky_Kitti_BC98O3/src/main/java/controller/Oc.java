package controller;

import Adatkezeles.Dao;
import Adatkezeles.Orarend_adattabla_GK;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.tinylog.Logger;

/**
 * A controller osztalyom itt történik meg például a loggolás vagy az adatok kezelése
 */
public class Oc {
    @FXML
    private TextField targy;

    @FXML
    private TextField nap;

    @FXML
    private TextField ora;

    @FXML
    private TextField evfolyam;


    @FXML
    private TextField osztaly;

    @FXML
    private Label eredmeny;

    private Dao dao;

    @FXML
    public void initialize() {
        Injector injector = Guice.createInjector(new PersistenceModule("orarend"));
        dao = injector.getInstance(Dao.class);
    }


    public void vegkiiratas(ActionEvent actionEvent) {
        if (!targy.getText().isBlank() && !evfolyam.getText().isBlank() && !ora.getText().isBlank() && !nap.getText().isBlank() && !osztaly.getText().isBlank()) {
            Orarend_adattabla_GK orarend = Orarend_adattabla_GK
                    .builder()
                    .targy(targy.getText())
                    .evfolyam(Integer.valueOf(evfolyam.getText()))
                    .ora(ora.getText())
                    .nap(nap.getText())
                    .osztaly(osztaly.getText())
                    .build();

            if (orarend.napValid()) {
                if (orarend.evfolyamValid()) {
                    dao.persist(orarend);
                    Logger.info("{} {} {} {} {} elmentve", orarend.getTargy(), orarend.getNap(), orarend.getOra(), orarend.getEvfolyam(), orarend.getOsztaly());
                    eredmeny.setText(orarend.getTargy() + " " + orarend.getNap() + " " + orarend.getOra() + " " + orarend.getEvfolyam() + " " + orarend.getOsztaly());
                } else {
                    Logger.warn("Nem érvényes évfolyamot adtál meg, kérlek 1-től 13-ig adja meg évfolyamot");
                }
            } else {
                Logger.warn("Nem érvényes napot adtál meg, kérlek hétfőtől péntekig adj meg napot");
            }
        } else {
            Logger.warn("Nem került kitöltésre minden mező, kérlek tölsd ki");
        }
    }


}

