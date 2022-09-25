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
public class Float implements AFD{
    public String getInteger(char current_char){
    String result="";
    while(current_char != '!' && Character.isDigit(current_char)){
        result += current_char;
        //System.out.println(result);
        break;
    }
    return result;
}
    
    @Override
    public Token processa(int pos, String texto){
        //System.out.println(pos);
        //System.out.println(texto);
        char current_char=texto.charAt(pos);
        //System.out.println(current_char);

        
        if (Character.isDigit(current_char)){
            String inteiro=getInteger(current_char);
            //System.out.println("\n");
            //System.out.println(teste);

           int tamanho=inteiro.length();
        return new Token("INTEGER", inteiro,tamanho);
    }
        
        return null;
    }
    
}
