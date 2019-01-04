package br.com.springboot.jemoliveira.demojemoliveira.service;

import br.com.springboot.jemoliveira.demojemoliveira.vo.CountryVO;

public interface IReadJsonService {
	
	CountryVO read(final String sigla);
		
}
