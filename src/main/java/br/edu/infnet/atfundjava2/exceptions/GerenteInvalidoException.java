/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.atfundjava2.exceptions;

/**
 *
 * @author rafae
 */
public class GerenteInvalidoException extends Exception {
private static final long serialVersionUID = 1L;
   
   public GerenteInvalidoException(String mensagem){
        super(mensagem);
   }
    
}
