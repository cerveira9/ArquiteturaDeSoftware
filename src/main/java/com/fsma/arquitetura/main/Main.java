package com.fsma.arquitetura.main;

import java.io.IOException;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.arquivo.LeitorTexto;
import com.fsma.arquitetura.persistencia.JPAUtil;
import com.fsma.arquitetura.processador.ProcessadorLinha;

public class Main {

	public static void main(String[] args)  {

		EntityManager em = JPAUtil.getEntityManager();
		try {
			String arquivo = "Empresas - São Paulo.csv";
			ProcessadorLinha processa = new ProcessadorLinha(em);
			LeitorTexto leitorDeTexto = new LeitorTexto();
			leitorDeTexto.lerLinhas(arquivo, processa);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
}
