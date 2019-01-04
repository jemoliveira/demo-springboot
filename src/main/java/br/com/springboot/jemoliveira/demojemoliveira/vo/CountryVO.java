package br.com.springboot.jemoliveira.demojemoliveira.vo;
import java.util.List;
 
public class CountryVO {
 
	private String sigla;
    private String name;
    private int population;
    private List<String> listOfStates;
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public List<String> getListOfStates() {
		return listOfStates;
	}
	public void setListOfStates(List<String> listOfStates) {
		this.listOfStates = listOfStates;
	}
    
	
    
}
 