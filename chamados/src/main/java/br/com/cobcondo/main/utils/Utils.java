package br.com.cobcondo.main.utils;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
			
	public static Boolean isEmail(String email){
		
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if(mat.matches()){
        	return true;        
        }else{
        	return false;
        }
	}
	
	public static Boolean isCPF(String cpf){
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
				cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))	return(false); 
			char dig10, dig11; 
			int sm, i, r, num, peso; 

			try { 
				sm = 0; peso = 10;
				
				for (i=0; i<9; i++) { 
					num = (int)(cpf.charAt(i) - 48); 
					sm = sm + (num * peso);
					peso = peso - 1;
				}
				
				r = 11 - (sm % 11); 
				if ((r == 10) || (r == 11)) dig10 = '0'; 
				else dig10 = (char)(r + 48); 
				
				sm = 0; peso = 11; 
				for(i=0; i<10; i++) { 
					num = (int)(cpf.charAt(i) - 48);
					sm = sm + (num * peso); 
					peso = peso - 1; 
					} 
				r = 11 - (sm % 11); 
				if ((r == 10) || (r == 11)) dig11 = '0'; 
				else dig11 = (char)(r + 48); 
				
				
				if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) return(true); 
				else return(false); 
				} catch (InputMismatchException erro) {
					return(false); 
					}
			} 
			
	public static String imprimeCPF(String cpf) { 
		return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11)); 
				}

	
	
}
