package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class ReponseSondage implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	
	private String reponse;
	@ManyToMany(mappedBy="reponses")
	private List<Personne> pesronnes ;
	
	
	public ReponseSondage() {
		super();
	}
	public ReponseSondage(String reponse) {
		super();
		this.reponse = reponse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public List<Personne> getPesronnes() {
		return pesronnes;
	}
	public void setPesronnes(List<Personne> pesronnes) {
		this.pesronnes = pesronnes;
	}
	
}
