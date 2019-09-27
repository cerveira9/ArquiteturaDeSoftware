package com.fsma.arquitetura.servico;

public class ComparadorCaracter {
	public static  boolean isVogal(char c) {
		c = Character.toLowerCase(c);
		return c == 97 || c == 101 || c == 105 || c == 111 || c == 117;
	}

	public static boolean isConsoante(char c) {
		return c == 98 || c == 99 || c == 100 || c == 102 || c == 103 || c == 104 || c == 106 || c == 107 || c == 108
				|| c == 109 || c == 110 || c == 112 || c == 113 || c == 114 || c == 115 || c == 116 || c == 118
				|| c == 119 || c == 120 || c == 121 || c == 122 || (c >= 128 && c <= 142);
	}
	public static boolean isEspacoEmBranco(char c) {
		return c == ' ';
	}
	
	public static int tamanhoEstring(String linha) {
		return linha.length();
	}

}
