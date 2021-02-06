package jspjdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.manzano.ejemplo.jspjdbc.business.BusinessDelegate;
import es.manzano.ejemplo.jspjdbc.model.Primaria;


public class BusinessDelegateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAllPrincipal() {				
		BusinessDelegate bd  =  BusinessDelegate.getInstance();

		for (Primaria primaria : bd.getAllPrimaria()) {
			System.out.println(primaria.getId());			
		}

		Primaria uno = new Primaria();
		uno.setCampo1("uno.campouno");
		uno.setCampo2("uno.campo2");
		uno.setCampo3("uno.campo3");
		bd.insertarPrimaria(uno);
		
		for (Primaria primaria : bd.getAllPrimaria()) {
			System.out.println(primaria.getId());			
		}
		
		//assertEquals(3, bd.getAllPrimaria().size());
	}

	@Test
	public final void testInsertarPrincipal() {
	//fail("Not yet implemented"); // TODO	
	}
	
	


}
