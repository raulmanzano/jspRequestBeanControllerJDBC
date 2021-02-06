#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jspjdbc.controllerBeans;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.jspjdbc.business.BusinessDelegate;
import ${package}.jspjdbc.model.Primaria;

public class PrimariaControllerBean {
	
	private static final Logger logger = LoggerFactory.getLogger(PrimariaControllerBean.class);

	//business delegate para operaciones
	private BusinessDelegate bd = null;
	
	//entidades que maneja y que hay generar metodos delegados
	private Primaria primaria= null;
	private List<Primaria> primarias= null;
	
	//resto de campos de lso formularios
	private String mensaje = null;
	private String operacion = null;

	//constructor sin argumentos
	public PrimariaControllerBean() {
		this.primaria = new Primaria();
		this.primarias = new ArrayList<Primaria>();
		this.bd = BusinessDelegate.getInstance();
		this.mensaje = null;
	}
	public Primaria getPrimaria() {
		return primaria;
	}
	public void setPrimaria(Primaria primaria) {
		this.primaria = primaria;
	}
	public List<Primaria> getPrimarias() {
		if (primarias.size()==0)
			this.primarias= bd.getAllPrimaria();
		return primarias;
	}
	public void setPrimarias(List<Primaria> primarias) {
		this.primarias = primarias;
	}
	public Integer getId() {
		return primaria.getId();
	}
	public void setId(Integer id) {
		primaria.setId(id);
	}
	public String getCampo1() {
		return primaria.getCampo1();
	}
	public void setCampo1(String campo1) {
		primaria.setCampo1(campo1);
	}
	public String getCampo2() {
		return primaria.getCampo2();
	}
	public void setCampo2(String campo2) {
		primaria.setCampo2(campo2);
	}
	public String getCampo3() {
		return primaria.getCampo3();
	}
	public void setCampo3(String campo3) {
		primaria.setCampo3(campo3);
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setOperacion(String operacion) throws Exception {
		logger.info("setOperacion");
		this.operacion= operacion;

		try {
			 switch (operacion) {
                case "Edit":
                	//carga valores para editarlo
                	primaria=bd.getById(getId());
                    break;
                case "Delete":
                	//elimina elemento                	
                	bd.delete(getId());
                	mensaje="Eliminado";
                    break;
                case "Nuevo":
                	//muestra formulario de nuevo
                    break;
                case "Editar":
                	//actualiza un elemento existente                	
                	bd.updatePrimaria(primaria);
                	mensaje="Actualizado";
                	break;
                case "Crear":
                	//crea un elemento existente
                	bd.insertarPrimaria(primaria);
                	mensaje="Creado";
                    break;
                default:
                	logger.info("Operacion Default!!!!!");
	            }
	        } catch (Exception ex) {
	        	throw new Exception("Problemas con la opercion",ex);
	        }
	}
	public String getOperacion() {
		return operacion;
	}
	
	
}
