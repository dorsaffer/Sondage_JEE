package Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Personne;
import entities.QuestionSondage;
import entities.ReponseSondage;




@Stateless
@LocalBean
public class ServiceQuestion implements QuestionLocal,QuestionRemote {
	@PersistenceContext
	EntityManager em;
	@Override
	public void ajouterQuestion(QuestionSondage question) {
		em.persist(question);
		
	}
	@Override
	public int ajouterReponse(ReponseSondage reponse) {
		em.persist(reponse);
		return reponse.getId();
	}
	@Override
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3) {
		
		QuestionSondage question = em.find(QuestionSondage.class, idQuestion);
		ReponseSondage reponse1 = em.find(ReponseSondage.class,idReponse1 );
		ReponseSondage reponse2 = em.find(ReponseSondage.class,idReponse2 );
		ReponseSondage reponse3 = em.find(ReponseSondage.class,idReponse3 );
		
		question.getReponses().add(reponse1);
		question.getReponses().add(reponse2);
		question.getReponses().add(reponse3);
	    em.persist(question);
	}
	@Override
	public void ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Personne personne) {
		
		if(personne.getReponses() == null){
			List<ReponseSondage> reponseSondages = new ArrayList<>();
			reponseSondages.add(em.find(ReponseSondage.class, reponseSondageId));
			personne.setReponses(reponseSondages);
		}else{
			personne.getReponses().add(em.find(ReponseSondage.class, reponseSondageId));
		}
		em.persist(personne);
		
	}
	@Override
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId) {
		Query query = em.createQuery("select p from Personne p where p.id=:personneId");
		query.setParameter("personneId", personneId);
		Personne p = (Personne) query.getSingleResult();
		return p.getReponses();
	}
	@Override
	public Long nbPersonnes() {
		Query query = em.createQuery("select count(p) from Personne p");
		return (Long)query.getSingleResult();
	}
	@Override
	public void affecterReponseAPersonne(int reponseId, int personneId) {
		Personne personne = em.find(Personne.class, personneId);
		personne.getReponses().add(em.find(ReponseSondage.class, reponseId));
		em.merge(personne);
		
	}
	@Override
	public Personne getEmployeByEmailAndPassword(String email, String password) {
		System.out.println(email + password);
		TypedQuery<Personne> query =
				em.createQuery("SELECT e FROM Personne e WHERE e.nom=:email AND e.prenom=:password", Personne.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				Personne employe = null;
				
				try {
				employe = query.getSingleResult();
				
				}
				catch (Exception e) {
				System.out.println("Erreur :" +e);
				}
				System.out.println(employe);
				return employe;
	}
	
	
	

}
