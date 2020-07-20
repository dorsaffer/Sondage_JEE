package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class QuestionSondage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	private String question;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<ReponseSondage> reponses;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<ReponseSondage> getReponses() {
		return reponses;
	}
	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}

}
