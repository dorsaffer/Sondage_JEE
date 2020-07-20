package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import Service.QuestionRemote;
import entities.QuestionSondage;


public class AddQuestion {

	public static void main(String[] args) {
		String jndiName ="/ExSondage-ear/ExSondage-ejb/ServiceQuestion!Service.QuestionRemote";
		Context cx;
		try {
			cx = new InitialContext();
			QuestionRemote proxy = (QuestionRemote) cx.lookup(jndiName);
			QuestionSondage question =new QuestionSondage();
			question.setQuestion("Quelle est votre chaîne TV préférée?");
			proxy.ajouterQuestion(question);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
