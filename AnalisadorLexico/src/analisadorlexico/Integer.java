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

public class Integer implements AFD{
    String tokens[]=null;
    public String getInteger(char current_char,String texto,int pos){
    String result="";
    int tam=texto.length();
    int aux;
    System.out.println("AKAKAKAK");
    System.out.println(texto);
    while(current_char != '!' && Character.isDigit(current_char)){
        
        result += current_char;
        if ((result).equals(texto)){
            return result;
        }
        if (pos<=tam){
            pos++;
            current_char=texto.charAt(pos);
        }
    }
    return null;
}
    
    @Override
    public Token processa(int pos, String texto){
       
        String split[]=null;
        split=texto.split(" ");
        System.out.println(split);
        for (int i=0;i<=split.length;i++){
            System.out.println(split[i]);
            pos=0;
            System.out.println(pos);
            char current_char=split[i].charAt(pos);
            boolean dot=split[i].contains(".");
            System.out.println(current_char);
            System.out.println(dot);
            
            if (Character.isDigit(current_char) && dot==false){
                String inteiro=getInteger(current_char,split[i],pos);
                int tamanho=inteiro.length();
                this.tokens[i]=inteiro;
                return new Token("INTEGER", inteiro,tamanho);
              
            }
        }
        for (int i=0;i<=this.tokens.length;i++){
            System.out.println(this.tokens[i]);
            return new Token("INTEGER", this.tokens[i],(this.tokens[i]).length());
        }
        return null;
    }
    
}
