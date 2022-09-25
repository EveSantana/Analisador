/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analisadorlexico;

/**
 *
 * @author unifebrito
 */
public class Token {
    private String tipo;
    private String valor;
    private int length;
    
    public Token(String tipo,String valor,int length){
        this.tipo=tipo;
        this.valor=valor;
        this.length=length;
      
    }
    
    @Override
    public String toString(){
        return "token<"+tipo+","+valor+">";
    }
    
    public String getTipo(){
        return tipo;
    }
    public String getValor(){
        return valor;
    }
    
    public int getLength(){
        return this.length;
    }
    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
    //}
    
}
