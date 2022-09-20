
package br.edu.infnet.atfundjava2.Testes;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.repository.ExternaRepository;
import br.edu.infnet.atfundjava2.service.ExternaService;

/**
 *
 * @author rafae
 */
public class ExternaTeste {
   public static void main(String[] args) {
/*	   
	   @Autowired
	   private ExternaRepository externaRepository;
	   
	   @Autowired 
	   private ExternaService externaService;
	   
	*/   
        try {
            Externa externa = new Externa( 4, true, "madeira");
            externa.setQntdVentiladores(3);
            externa.setCadeiraAcolchoada(true);
            externa.setMusico("Jota Quest");
            System.out.println(externa);
            
       } catch (QualidadeMesaException | QntdLugaresException e) {
            System.out.println(e.getMessage());
            
        }
  }
}
