package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionário extends Pessoa {

	private BigDecimal salario;
	private String funcao;
	
	public Funcionário() {
		super();
	}

	public Funcionário(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	//Item 3.4 do desafio
	public void aumentoSalario() {
		salario = salario.multiply(BigDecimal.valueOf(0.1)).add(salario);
	}
	
	//Item 3.12 do desafio
	public double quantidadeSalarioMinimo(BigDecimal salario) {
		double QuantSalarioMinimo = 0.0;
		return QuantSalarioMinimo = salario.doubleValue() / 1212;
		
	}
		
}
