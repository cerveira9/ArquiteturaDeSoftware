package com.fsma.arquitetura.servico;

import static com.fsma.arquitetura.servico.ComparadorCaracter.isConsoante;
import static com.fsma.arquitetura.servico.ComparadorCaracter.*;


public class AnalisadorLinha implements ProcessadorLinha{
	private String linha;
	int vog = 0, cons = 0, esp = 0;

	
	@Override
	public void processa(String linha) {
		this.linha = linha;
		this.linha = this.linha.toLowerCase();		
	}
	
	public int getTamanhoLinha() {
		return tamanhoEstring(linha);
	}

	public void getQuantidadeVogai() {
		for (int i = 0; i < this.linha.length(); i++) {
			char c = this.linha.charAt(i);
			if (isVogal(c)) {
				vog++;
			}
		}
		System.out.println(vog);
	}

	public void getQuantidadeConsoante() {
		for (int i = 0; i < this.linha.length(); i++) {
			char c = this.linha.charAt(i);
			if (isConsoante(c)) {
				cons++;
			}
		}
		System.out.println(cons);
	}

	public void getQuantidadeEspaco() {
		for (int i = 0; i < this.linha.length(); i++) {
			char c = this.linha.charAt(i);
			if (isEspacoEmBranco(c)) {
				esp++;
			}
		}
		System.out.println(esp);
	}
}
