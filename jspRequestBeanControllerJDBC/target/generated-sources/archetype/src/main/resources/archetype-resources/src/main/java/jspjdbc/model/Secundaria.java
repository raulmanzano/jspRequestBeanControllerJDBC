#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jspjdbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the secundaria database table.
 * 
 */
public class Secundaria implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String campo1;

	private String campo2;

	private String campo3;

	private Primaria primaria;

	public Secundaria() {
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

	public Primaria getPrimaria() {
		return this.primaria;
	}

	public void setPrimaria(Primaria primaria) {
		this.primaria = primaria;
	}

}