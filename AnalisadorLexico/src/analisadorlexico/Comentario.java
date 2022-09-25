/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Evelyn
 */
//public class FloatReservada {
    
//}

public class Comentario implements AFD{
    Map<String, String> map = new HashMap<>();
    
    public String checkComentario(char current_char){
       
       String result=""; 
       while(current_char != '!' && Character.isAlphabetic(current_char)){
        result += current_char;
        break;
    }
    return result;
    }
    
    @Override
    
    public Token processa(int pos, String texto){
            
       
           char current_char=texto.charAt(pos);
            if (current_char=='"'){
                String letra=checkComentario(current_char);
                int tamanho=letra.length();
                return new Token("ID",letra,tamanho);
            }
            return null;
       }
       
           
       } 
    
