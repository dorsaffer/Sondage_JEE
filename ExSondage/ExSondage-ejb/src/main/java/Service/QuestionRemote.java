package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Personne;
import entities.QuestionSondage;
import entities.ReponseSondage;

@Remote
public interface QuestionRemote {
	public void ajouterQuestion(QuestionSondage question);
	public int ajouterReponse(ReponseSondage reponse);
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2,int idReponse3);
	public void ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Personne personne);
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId);
	public Long nbPersonnes();
	public void affecterReponseAPersonne(int reponseId, int personneId);
	public Personne getEmployeByEmailAndPassword(String email, String password);
	
}
