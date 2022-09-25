/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisadorlexico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unifebrito
 */
public class Lexer {
    private String texto;
    private int pos;
    private char current_char;
    private List<AFD> afds;
    
    public Lexer(String texto){
        this.texto=texto;
        this.pos=0;
        this.current_char=texto.charAt(pos);
        afds=new ArrayList<>();
        afds.add(new Plus());
        afds.add(new Menos());
        afds.add(new Integer());
        afds.add(new Letra());
        //afds.add(new FloatReservada());
        
        
       
    }
    
    public void error(){
        throw new RuntimeException("Invalid character");
        
    }
    
   // public void advance(){
     //   pos += 1;
       // if (pos > (texto.length()-1)){
         //   current_char = '!';
        //}else{
          //  current_char = texto.charAt(pos);
        //}
    //}

    public void advance(int qntd){
        pos +=qntd;
        
        if(pos>(texto.length()-1)){
            current_char='!'; 
        }else{
            current_char=texto.charAt(pos);
        }
  
    }
    public void skip_whitespace(){
        while (current_char != '!' && current_char == ' '){
            advance(1);
     }
        
        
    }
    
    /*public boolean isDigit(char c){
        switch(c){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            return true;
        }
    return false;
    }*/
   /* public static boolean isLetter(char ch) {
        return true;
    }*/
    
    
  /* public String getInteger(){
    String result="";
    while(current_char != '!' && isDigit(current_char)){
        result += current_char;
        advance(1);
    }
    return result;
}*/
   
   public Token getNextToken(){

    while(current_char != '!'){
        if (current_char == ' '){
            skip_whitespace();
            continue;
    }
        
    for (AFD afd: afds){
        Token reconhecido=afd.processa(pos,texto);
        if(reconhecido != null){
            advance(reconhecido.getLength());
            return reconhecido;
        }
    }
    
   

    //if (isDigit(current_char)){
      //  return new Token("INTEGER", getInteger(),-1);
    //}
    
    //if (Character.isAlphabetic(current_char)){
      //  return new Token("ID",getID(),-1);
        
    //}

   /* if (current_char == '+'){
        advance();
        return new Token("PLUS", "+");
    }*/

   /* if (current_char == '-'){
        advance(1);
        return new Token("MINUS", "-",-1);
    }*/

    if (current_char == '*'){
        advance(1);
        return new Token("MUL", "*",-1);
 }

    if (current_char == '/'){
        advance(1);
        return new Token("DIV", "/",-1);
    }

    if (current_char == '('){
        advance(1);
        return new Token("LPAREN", "(",-1);
    }

    if (current_char == ')'){
        advance(1);
        return new Token("RPAREN", ")",-1);
    }

    error();
    }
        return new Token("EOF", "!",-1);
    }
}


