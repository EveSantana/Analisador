/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author Evelyn
 */
public class Letra implements AFD{
    Map<String, String> map = new HashMap<>();
    int aux=0;
    int posicao_aux=0;
    boolean Controle;
    /*public String getID(char current_char){
       String result=""; 
       while(current_char != '!' && Character.isAlphabetic(current_char)){
        result += current_char;
        break;
    }
    return result;
    }*/
    
    public String getID(char current_char,String texto,int pos){
    String result="";
    int tam=texto.length();
    //System.out.println("AKAKAKAK");
    //System.out.println(texto);
    while(current_char != '!' && Character.isAlphabetic(current_char)){
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
        String valor="";
        String texto_split[]=null;
        //String t[]=null;
        ArrayList<String> t=new ArrayList<String>();
        this.map.put("float","RESERVADA_FLOAT");
        this.map.put("int","RESERVADA_INT");
        this.map.put("return","RESERVADA_RETURN");
        texto_split=texto.split(" ");
        
         for (int i=0;i<= texto_split.length;i++){
             valor=texto_split[i];
             pos=0;
             /*System.out.printf("posicao: %d", this.posicao_aux);
             System.out.println();
            
            if (i == this.aux){
                this.aux=i+1;
                this.posicao_aux=0;
                this.Controle=true;
            }*/
            
            
            if ((valor.trim().equals("float")) || (valor.trim().equals("int")) || (valor.trim().equals("return"))){
                String palavra_reservada=this.map.get(valor.trim());
                return new Token(palavra_reservada,valor,valor.length());
            }else{
                
               /* while (this.posicao_aux<=valor.length()){
                    System.out.println(valor);
                    System.out.println(i);
                    System.out.println(this.aux);
                    System.out.printf("posicao22: %d", this.posicao_aux);
                    if (this.Controle==true){
                    this.posicao_aux=this.posicao_aux+1;
                     }*/
                    char current_char=valor.charAt(pos);
                    
                    if (Character.isAlphabetic(current_char)){
                        String letra=getID(current_char,valor,pos);
                        int tamanho=letra.length();
                        t.add(letra);
                        //t[i]=letra;
                       return new Token("ID",letra,tamanho);
                    }
                //}
            }            
        }
         
         for (String i:t){
             System.out.println((i));
             return new Token("ID",i,(i).length());
         }
        return null; 
    } 
}

       
        
      
   