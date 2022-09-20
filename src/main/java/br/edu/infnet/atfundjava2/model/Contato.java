
package br.edu.infnet.atfundjava2.model;

import br.edu.infnet.atfundjava2.exceptions.GerenteInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.EndereçoInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.TelefoneInvalidoException;

public class Contato {
    protected String endereço;
    private String telefone;
    private String gerente;

    
     @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(endereço);
        sb.append(";");
        sb.append(telefone);
        sb.append(";");
        sb.append(gerente);
        
        return sb.toString();
       
                             
    }
    public Contato(String endereço, String telefone, String gerente) throws Exception {
        
        if (endereço == null){
            throw new EndereçoInvalidoException("Nome do endereço invalido, como chegarei no local? ");
        }
        if (telefone == null){
            throw new TelefoneInvalidoException("Numero de telefone invalido, como ligarei para o local? ");
        }
        if (gerente == null){
            throw new GerenteInvalidoException("Nome do gerente invalido, como falarei com alguem do local? ");
        }
        this.endereço = endereço;
        this.telefone = telefone;
        this.gerente = gerente;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getGerente() {
        return gerente;
    }

    
}