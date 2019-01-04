package br.com.springboot.jemoliveira.demojemoliveira.service.impl;

import org.springframework.stereotype.Service;

import br.com.springboot.jemoliveira.demojemoliveira.service.IJemoliveiraService;

@Service
public class JemoliveiraService implements IJemoliveiraService {

	@Override
	public String showMessage() {
		return "Welcome to jemolvieira spring boot app";
	}

	@Override
	public String insertMessage(String text) {
		return "Message inserted is: " + text;
	}
	
}