package main;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.QuestionRemote;
import entities.Personne;
import entities.QuestionSondage;
import entities.ReponseSondage;

public class AddPersonne {

	public static void main(String[] args) {
		String jndiName ="/ExSondage-ear/ExSondage-ejb/ServiceQuestion!Service.QuestionRemote";
		Context cx;
		try {
			cx = new InitialContext();
			QuestionRemote proxy = (QuestionRemote) cx.lookup(jndiName);
			Personne hediZITOUNI = new Personne("ZITOUNI", "Hedi", 45);
			Personne helaBOUAZIZ = new Personne("BOUAZIZ", "Hela", 23);		
			Personne mariemHENI = new Personne("HENI", "Mariem", 55);
			/*proxy.ajouterPersonneEtAffecterReponse(1, hediZITOUNI);
			proxy.ajouterPersonneEtAffecterReponse(2, helaBOUAZIZ);
			proxy.ajouterPersonneEtAffecterReponse(3, mariemHENI);
			
		
			proxy.affecterReponseAPersonne(3,4);
			proxy.affecterReponseAPersonne(2,4);

			*/
			//III.3.1
			//fetch
			System.out.println("***************  Les reponses de Hela BOUAZIZ sont : ");
			List<ReponseSondage> reponseSondages = proxy.getAllResponsesParPersonnes(2);
			for (ReponseSondage reponseSondage : reponseSondages) {
				System.out.println(reponseSondage.getReponse());
			}
			
			//III.3.2
			System.out.println("*******************Nombre de personnes qui ont repondu : " + proxy.nbPersonnes());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
