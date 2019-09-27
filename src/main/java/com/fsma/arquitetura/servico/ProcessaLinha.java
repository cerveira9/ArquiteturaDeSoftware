package com.fsma.arquitetura.servico;

public class ProcessaLinha implements ProcessadorLinha{
	Imprimir imprimirLinha;
	@Override
	public void processa(String linha) {
		System.out.println(linha);
	}
}
