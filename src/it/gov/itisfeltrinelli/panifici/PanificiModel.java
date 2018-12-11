package it.gov.itisfeltrinelli.panifici;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
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
	public ObservableList<String> getCitta(String provincia) {
		ObservableList<String> list=FXCollections.observableArrayList(daoPanifici.getCitta(provincia));
		Collections.sort(list);
		return (ObservableList<String>) list;
	}
	
	/**
	 * restituisce la lista delle panetterie come stringa che ad ogni entry va a capo.
	 * @param provincia
	 * @param citta
	 * @return
	 */
	public String getFormattedResults(String provincia, String citta){
		String result="";
		System.out.println("Sono dentro results");
		for(Panificio p:panifici) {
			
			if(p.getProvincia().equals(provincia) && p.getCitta().equals(citta)) {
				System.out.println(p.getPanetteria());
				result+=p.getPanetteria()+"\n";
			}
		}
		return result;
	}
	
	public ObservableList<String> getProvince() {
		ObservableList<String> list=FXCollections.observableArrayList(daoPanifici.getProvincia());
		ArrayList<String> noDuplicates=new ArrayList<String>();
		System.out.println("ah"+list);
		boolean found=false;
		for(String s:list) {
			for(String s1:noDuplicates) {
				if(s.equals(s1)) {
					found=true;
					break;
				}
			}
			if(found==false)
				noDuplicates.add(s);
			else
				found=false;
		}
		Collections.sort(noDuplicates);
		System.out.println(FXCollections.observableArrayList(noDuplicates));
		return FXCollections.observableArrayList(noDuplicates);
	}
}
