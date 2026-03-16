/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.filmes.view;
import java.util.Scanner;

/**
 *
 * @author dave
 */


public class Principal {
	Scanner sc = new Scanner(System.in);	

	public String ler_serie(){
		System.out.print("Digite uma série: ");
		String serie = sc.nextLine();
		return serie.replace(" ", "+");
	};
	
}
