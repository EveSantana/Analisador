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
    
    @Override
    public Token processa(int pos, String texto){
    String split[]=null;       
    split=texto.split(" "); 
    
    for (int i=0;i<=split.length;i++){
        System.out.println(split[i]);
         if(split[i].contains(".") && (split[i].contains("0")||split[i].contains("1")||split[i].contains("2")||split[i].contains("3")||split[i].contains("4")||split[i].contains("5")||split[i].contains("6")||split[i].contains("7")||split[i].contains("8")||split[i].contains("9"))){
           int tamanho=split[i].length();
           return new Token("FLOAT", split[i],tamanho);
    }
    }
        
        return null;
    }
    
}
