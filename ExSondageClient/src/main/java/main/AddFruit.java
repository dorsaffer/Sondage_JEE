package main;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.QuestionRemote;
import entities.QuestionSondage;
import entities.ReponseSondage;

public class AddFruit {

	public static void main(String[] args) {
		String jndiName ="/ExSondage-ear/ExSondage-ejb/ServiceQuestion!Service.QuestionRemote";
		Context cx;
		try {
			cx = new InitialContext();
			QuestionRemote proxy = (QuestionRemote) cx.lookup(jndiName);
			QuestionSondage question =new QuestionSondage();
			
			ReponseSondage fraise = new ReponseSondage("Fraise");
			ReponseSondage orange = new ReponseSondage("Orange"); 
			ReponseSondage kiwi = new ReponseSondage("Kiwi");
			List<ReponseSondage> listReponsesFruitPrefere = new ArrayList<ReponseSondage>();
			listReponsesFruitPrefere.add(fraise);
			listReponsesFruitPrefere.add(orange);
			listReponsesFruitPrefere.add(kiwi);
			question.setQuestion("Quel est votre fruit préférée?");
			question.setReponses(listReponsesFruitPrefere);
			proxy.ajouterQuestion(question);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
