package br.usjt.ccp3bn_bua2_previsao_tempo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.ccp3bn_bua2_previsao_tempo.ConverteStringForDate;
import br.usjt.ccp3bn_bua2_previsao_tempo.model.DiaDaSemana;
import br.usjt.ccp3bn_bua2_previsao_tempo.model.PrevisaoTempo;

public class InserePrevisaoTempoComSemana {
	
	public static void main (String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		
		DiaDaSemana diaDaSemana = new DiaDaSemana();
		diaDaSemana.setNomeDaSemana("Segunda-Feira");
		
		manager.persist(diaDaSemana);
		
		PrevisaoTempo previsaoTempo = new PrevisaoTempo();
		previsaoTempo.setDescricao("Sol com poucas. Não chove");
		previsaoTempo.setTempMin(13.0);
		previsaoTempo.setTempMax(25.0);
		previsaoTempo.setUmidade(81);
		
		ConverteStringForDate convData = new ConverteStringForDate();
		previsaoTempo.setDataHora(convData.convertDate("01/04/2020 22:50"));
		
		previsaoTempo.setLatitude(-21.5475);
		previsaoTempo.setLongitude(-43.6000);
		previsaoTempo.setDiaDaSemana(diaDaSemana);
		
		manager.persist(previsaoTempo);
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
		
	}

}
