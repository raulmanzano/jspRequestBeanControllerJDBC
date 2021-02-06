package es.manzano.ejemplo.jspjdbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


public class Primaria implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String campo1;
	private String campo2;
	private String campo3;

	private List<Secundaria> secundarias;

	public Primaria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCampo3() {
		return this.campo3;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}

	public List<Secundaria> getSecundarias() {
		return this.secundarias;
	}

	public void setSecundarias(List<Secundaria> secundarias) {
		this.secundarias = secundarias;
	}

	public Secundaria addSecundaria(Secundaria secundaria) {
		getSecundarias().add(secundaria);
		secundaria.setPrimaria(this);

		return secundaria;
	}

	public Secundaria removeSecundaria(Secundaria secundaria) {
		getSecundarias().remove(secundaria);
		secundaria.setPrimaria(null);

		return secundaria;
	}

}