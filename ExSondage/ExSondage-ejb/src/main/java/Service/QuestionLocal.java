package Service;

import javax.ejb.Local;

import entities.Personne;
import entities.QuestionSondage;


@Local
public interface QuestionLocal {
	public void ajouterQuestion(QuestionSondage question);
	public Personne getEmployeByEmailAndPassword(String email, String password);
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3);
}
