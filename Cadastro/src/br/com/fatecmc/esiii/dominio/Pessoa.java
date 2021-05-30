package br.com.fatecmc.esiii.dominio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Pessoa extends EntidadeDominio {
	private String pnome;
	private String mnome;
	private String unome;
	private String email;
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	private String cadastro = dt.format(LocalDateTime.now());

	

	public Pessoa () {}
	
	public Pessoa (	
		String pnome,
		String mnome,
		String unome,
		String email,
		String cadastro
		) {
		this.pnome=pnome;
		this.mnome=mnome;
		this.unome=unome;
		this.email=email;
		this.cadastro=cadastro;

	}
	public String getPnome() {
		return pnome;
	}

	public void setPnome(String pnome) {
		this.pnome = pnome;
	}

	public String getMnome() {
		return mnome;
	}

	public void setMnome(String mnome) {
		this.mnome = mnome;
	}

	public String getUnome() {
		return unome;
	}

	public void setUnome(String unome) {
		this.unome = unome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String data) {
		this.cadastro = data;
	}

}