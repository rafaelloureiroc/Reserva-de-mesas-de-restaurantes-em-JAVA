
package br.edu.infnet.atfundjava2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;

@Entity
@Table(name = "TExterna")

public class Externa extends Local {
    private int qntdVentiladores;
    private String Musico;
    private boolean cadeiraAcolchoada;

    public Externa( int qntdLugares, boolean cadeiraEspecial, String qualidadeMesa) throws QualidadeMesaException, QntdLugaresException {
        super(qntdLugares, cadeiraEspecial,   qualidadeMesa);
    }
    public Externa() {
    	super();
		// TODO Auto-generated constructor stub
	}
    
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); 
        sb.append( ";"); 
        sb.append(qntdVentiladores); 
        sb.append(";"); 
        sb.append(Musico); 
        sb.append(";"); 
        sb.append(cadeiraAcolchoada); 
        sb.append(";");
        
        
        return sb.toString();
    }
    
    @Override
    public float calcularAdicionalPelaMesa() {
        float valorMesa = (qntdLugares * 4f) + (cadeiraEspecial ?  +50 :0)+(cadeiraAcolchoada ? - 100:0);
                return valorMesa;
                //qntd 16 + 250 = 266 + 200 = 466 - 300 = 366
    }
    
    public int getQntdVentiladores() {
        return qntdVentiladores;
    }

    public void setQntdVentiladores(int qntdVentiladores) {
        this.qntdVentiladores = qntdVentiladores;
    }

    public String getMusico() {
        return Musico;
    }

    public void setMusico(String Musico) {
        this.Musico = Musico;
    }

    public boolean isCadeiraAcolchoada() {
        return cadeiraAcolchoada;
    }

    public void setCadeiraAcolchoada(boolean cadeiraAcolchoada) {
        this.cadeiraAcolchoada = cadeiraAcolchoada;
    }

   
    
}