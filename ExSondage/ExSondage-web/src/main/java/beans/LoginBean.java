package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import Service.QuestionLocal;
import entities.Personne;




@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	private String login;
	private String password;
	private Personne employe;
	private Boolean loggedIn; 
	
	@EJB
	QuestionLocal employeService;
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Personne getEmploye() {
		return employe;
	}

	public void setEmploye(Personne employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	

	public String doLogin() {
	String navigateTo = "null";

	employe = employeService.getEmployeByEmailAndPassword(login, password);
	
	if (employe != null ) {
	navigateTo = "/pages/Welcome?faces-redirect=true";
	loggedIn = true;
	}

	else {
	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
	}
	return navigateTo ;
	}
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login?faces-redirect=true";
		}
}
