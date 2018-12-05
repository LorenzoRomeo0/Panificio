package it.gov.itisfeltrinelli.panifici;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

public class PanificiModel {
	ArrayList<Panificio> panifici;
	DAOPanifici daoPanifici=new DAOPanifici();
	
	PanificiModel(){
		panifici=daoPanifici.getPanifici();
	}
	/*
	 * prende le province di una determinata citta
	 */
	public ObservableList getProvincia(String citta) {
		List<String> list=new ArrayList<String>();
		
		return list;
	}
	
}
