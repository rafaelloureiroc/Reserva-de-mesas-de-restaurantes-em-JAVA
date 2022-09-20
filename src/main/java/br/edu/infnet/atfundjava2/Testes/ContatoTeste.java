
package br.edu.infnet.atfundjava2.Testes;

import br.edu.infnet.atfundjava2.exceptions.EndereçoInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.GerenteInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;
import br.edu.infnet.atfundjava2.model.Contato;

/**
 *
 * @author rafae
 */
public class ContatoTeste {
    public static void main(String[] args) throws Exception{
        try {
            Contato contato = new Contato("rua domingos", "(21) 2605-4352", "Marcos andrade");
            System.out.println(contato);
        } catch (QntdLugaresException |GerenteInvalidoException |EndereçoInvalidoException e) {
            System.out.println(e.getMessage());
       }
    }
}