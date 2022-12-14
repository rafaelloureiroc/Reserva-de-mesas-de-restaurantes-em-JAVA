
package br.edu.infnet.atfundjava2.Testes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.atfundjava2.exceptions.EndereçoInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.GerenteInvalidoException;
import br.edu.infnet.atfundjava2.exceptions.MesaInvalidaException;
import br.edu.infnet.atfundjava2.exceptions.QualidadeMesaException;
import br.edu.infnet.atfundjava2.exceptions.QntdLugaresException;
import br.edu.infnet.atfundjava2.exceptions.TelefoneInvalidoException;
import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Contato;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.model.Local;
import br.edu.infnet.atfundjava2.model.MesaInterna;
import br.edu.infnet.atfundjava2.model.Restaurante;
        
public class ArquivoRestauranteTeste {
	/*public static void main(String[] args) throws Exception {
		
		try {
	
			String arquivo = "restaurante.txt";
			
			FileReader fileR = new FileReader(arquivo);
			BufferedReader leitura = new BufferedReader(fileR);
			
			FileWriter fileW = new FileWriter("out_"+arquivo);
			BufferedWriter escrita = new BufferedWriter(fileW);
			
			String linha = leitura.readLine();
			
			String[] campos = null;
			
			List<Local> localMesas = new ArrayList<Local>();

			Restaurante restaurante =  null;
                       
			while(linha != null) {
				campos = linha.split(";");
				
				String tipo = campos[0];
				
				switch (tipo.toUpperCase()) {
				case "R":				
                                        Contato contato = null;
                                    try{

                                           contato = new Contato(campos[1], campos[2],campos[3]);
                                    } catch (TelefoneInvalidoException |GerenteInvalidoException |EndereçoInvalidoException e) {
                                                 System.out.println(e.getMessage());
                                          }
                                           restaurante = new Restaurante();
                                           restaurante.setNome(campos[4]);
                                           restaurante.setContato(contato);
                                           restaurante.setVegano(Boolean.valueOf(campos[6]));
                                           restaurante.setDescricao(campos[5]);
                                           restaurante.setLocal(localMesas);
                                          
                                     
                                                break;
				case "B":
                                        try {
                                            Balcao balcao = new Balcao(Integer.valueOf(campos[1]), Boolean.valueOf(campos[2]), Integer.valueOf(campos[3]));
                      
                                            balcao.setBebidaAlcoolica(campos[4]);
                      
                                            balcao.setPetisco(campos[5]);
                                                    
                                            balcao.setShotsAlcoolicos(Integer.valueOf(campos[6]));
                                            localMesas.add(balcao);        
                                            //System.out.println(balcao);
                                        } catch (PreçoMesaException | QntdLugaresException e) {
                                            System.out.println(e.getMessage());
                                        }
                                                break;
					
				case "M":
                                   try {
                                               
                                        MesaInterna mesa = new MesaInterna( Integer.valueOf(campos[1]),Boolean.valueOf(campos[2]),Integer.valueOf(campos[3]));
                                                
                                       mesa.setVelaRomantica(Boolean.valueOf(campos[4]));
                                                
                                       mesa.setArCondicionado(Boolean.valueOf(campos[5]));
                                                
                                       mesa.setIluminacaoEspecial(campos[6]);
                                       localMesas.add(mesa);
                                                //System.out.println(mesa);
                                   } catch (QntdLugaresException | PreçoMesaException e) {
                                            System.out.println(e.getMessage());
                                            }
                                   
						
						break;
					
				case "E":
                                    try {
                                        Externa externa = new Externa(Integer.valueOf(campos[1]),Boolean.valueOf(campos[2]),Integer.valueOf(campos[3]));
                                                 
                                        externa.setQntdVentiladores(Integer.valueOf(campos[4]));
                                                   
                                        externa.setCadeiraAcolchoada(Boolean.valueOf(campos[5]));
                                                  
                                        externa.setMusico(campos[6]);
                                        localMesas.add(externa);
                                       
                                        //System.out.println(externa);
                                   } catch (PreçoMesaException | QntdLugaresException e) {
                                        System.out.println(e.getMessage());
                                    }
				
		}
				
				linha = leitura.readLine();
                                
                try {
                    
                   restaurante.impressao();
                   escrita.write(restaurante.obterLinhaGravaçãoArquivo());				
                } catch (MesaInvalidaException e) {
                    System.out.println(e.getMessage());
			}}			
			
			leitura.close();
			escrita.close();
                        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}