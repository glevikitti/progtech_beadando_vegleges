package Adatkezeles;

import com.google.inject.Guice;
import com.google.inject.Injector;
import controller.Oc;
import guice.PersistenceModule;
public class Main_Dao {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("Orarend_adattabla_GK"));

        Oc oc= new Oc();
        Dao dao2;




    }
}