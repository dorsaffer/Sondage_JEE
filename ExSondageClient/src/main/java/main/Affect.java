package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.QuestionRemote;


public class Affect {

	public static void main(String[] args) {
		String jndiName ="/ExSondage-ear/ExSondage-ejb/ServiceQuestion!Service.QuestionRemote";
		Context cx;
		try {
			cx = new InitialContext();
			QuestionRemote proxy = (QuestionRemote) cx.lookup(jndiName);
			proxy.affecterQuestionReponses(1, 7, 8, 9);
			
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
