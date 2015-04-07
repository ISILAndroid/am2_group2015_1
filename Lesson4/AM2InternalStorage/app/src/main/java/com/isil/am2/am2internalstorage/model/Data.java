package com.isil.am2.am2internalstorage.model;

import java.util.ArrayList;
import java.util.List;


public class Data {
    private static Data INSTANCE = null;
    
    private static List<NoteEntity> notes;
 


	// Private constructor suppresses 
    private Data(){}
 
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciaci�n m�ltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Data();
            notes =new ArrayList<NoteEntity>();
        }
    }
 
    public static Data getInstance() {
        createInstance();
        return INSTANCE;
    }
    
    public void addNote (NoteEntity _note)
    {
    	notes.add(_note);
    }
    
    public static List<NoteEntity> getNotes() {
		return notes;
	}
}
