package br.com.springboot.jemoliveira.demojemoliveira.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.springboot.jemoliveira.demojemoliveira.service.IReadJsonService;
import br.com.springboot.jemoliveira.demojemoliveira.vo.CountryVO;

@Service
public class ReadJsonService implements IReadJsonService {

	@Value("${jsonFile}")
	private String jsonFile;

	@Override
	public CountryVO read(String sigla) {


		InputStream input = getClass().getResourceAsStream(jsonFile);

		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		Gson gson = new Gson();

		CountryVO[] array = gson.fromJson(br, CountryVO[].class);

		List<CountryVO> list = Arrays.asList(array);

		CountryVO matchingObject = list.stream()
				.filter(x -> x.getSigla().equals(sigla))
				.findAny().orElse(null);

		return matchingObject;
	}
}