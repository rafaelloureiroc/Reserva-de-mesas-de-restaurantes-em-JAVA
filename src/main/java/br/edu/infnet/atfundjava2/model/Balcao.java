
package br.edu.infnet.atfundjava2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;


@Entity
@Table(name = "TBalcao")
public class Balcao extends Local {
	
   private String bebidaAlcoolica;
   private int ShotsAlcoolicos;
   private String petisco;

   public Balcao() {
		// TODO Auto-generated constructor stub
	}
   
    public Balcao(int qntdLugares, boolean cadeiraEspecial,  String qualidadeMesa) throws QualidadeMesaException, QntdLugaresException {
        super(qntdLugares, cadeiraEspecial, qualidadeMesa);
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); 
        sb.append( ";"); 
        sb.append(bebidaAlcoolica); 
        sb.append(";"); 
        sb.append(ShotsAlcoolicos); 
        sb.append(";"); 
        sb.append(petisco); 
        sb.append(";");
        
        
        return sb.toString();
    }

   
   @Override
    public float calcularAdicionalPelaMesa() {
        float valorMesa =  (qntdLugares * 5f) + (cadeiraEspecial ? +50 :0)+ (ShotsAlcoolicos * 4f);
                return valorMesa;
    }           // 100 + 20 + 50 + 24 = 184
   
    public String getBebidaAlcoolica() {
        return bebidaAlcoolica;
    }

    public void setBebidaAlcoolica(String bebidaAlcoolica) {
        this.bebidaAlcoolica = bebidaAlcoolica;
    }

    public int getShotsAlcoolicos() {
        return ShotsAlcoolicos;
    }

    public void setShotsAlcoolicos(int ShotsAlcoolicos) {
        this.ShotsAlcoolicos = ShotsAlcoolicos;
    }

    public String getPetisco() {
        return petisco;
    }

    public void setPetisco(String petisco) {
        this.petisco = petisco;
    }

  
   
   
}