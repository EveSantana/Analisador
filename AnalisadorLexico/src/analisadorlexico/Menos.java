/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisadorlexico;

/**
 *
 * @author unifebrito
 */
public class Menos implements AFD{
    @Override
    
    public Token processa(int pos, String texto){
        System.out.println(pos);
        char current_char=texto.charAt(pos);
        if (current_char=='-'){
            return new Token("MINUS","-",1);
        }
        return null;
    }
    
}