/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisadorlexico;

/**
 *
 * @author unifebrito
 */
import java.util.Scanner;

 public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);

 try {

    while (true) {
       System.out.print("myLexer>: ");
       String text = sc.nextLine();
       Lexer lexer = new Lexer(text);
       Token token = lexer.getNextToken();
       // imprime todos os tokens
       while (!token.getTipo().equals("EOF")) {
           System.out.println(token);
           token = lexer.getNextToken();
        }
    }
 }catch (RuntimeException re) {
    System.out.println("Error: " + re.getMessage());
    sc.close();
    }
  }
}

