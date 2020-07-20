package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.QuestionRemote;
import entities.QuestionSondage;
import entities.ReponseSondage;

public class AddReponse {

	public static void main(String[] args) {
		String jndiName ="/ExSondage-ear/ExSondage-ejb/ServiceQuestion!Service.QuestionRemote";
		Context cx;
		try {
			cx = new InitialContext();
			QuestionRemote proxy = (QuestionRemote) cx.lookup(jndiName);
			ReponseSondage reponse =new ReponseSondage();
			reponse.setReponse("nessma");
			int rep=	proxy.ajouterReponse(reponse);
			
			ReponseSondage reponse1 =new ReponseSondage();
			reponse1.setReponse("hannibal");
			int rep2= proxy.ajouterReponse(reponse1);
			
			ReponseSondage reponse2 =new ReponseSondage();
			reponse2.setReponse("Ettounsia");
			int rep3 =proxy.ajouterReponse(reponse2);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
