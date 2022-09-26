/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

/**
 *
 * @author Evelyn
 */
public class Div implements AFD{
    @Override
    
    public Token processa(int pos, String texto){
        char current_char=texto.charAt(pos);
        if (current_char=='/'){
            return new Token("Div","/",1);
        }
        return null;
    }
    
}