package application;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import entities.Funcionário;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Funcionário> funcionarios = new ArrayList<>();
		
		//formatação para a saída do salário
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);
		decimalFormat.setDecimalSeparatorAlwaysShown(true);
		decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols());
		
		//3.1 - Inserção hardcode dos funcionários da tabela, para não ter que solicitar a inclusão de cada um manualmente
		Funcionário func1 = new Funcionário("Maria", LocalDate.parse("18/10/2000", dtf), new BigDecimal(2009.44) , "Operador");
		funcionarios.add(func1);
		Funcionário func2 = new Funcionário("João", LocalDate.parse("12/05/1990", dtf), new BigDecimal(2284.38) , "Operador");
		funcionarios.add(func2);
		Funcionário func3 = new Funcionário("Caio", LocalDate.parse("02/05/1961", dtf), new BigDecimal(9836.14) , "Coordenador");
		funcionarios.add(func3);
		Funcionário func4 = new Funcionário("Miguel", LocalDate.parse("14/10/1988", dtf), new BigDecimal(19119.88) , "Diretor");
		funcionarios.add(func4);
		Funcionário func5 = new Funcionário("Alice", LocalDate.parse("05/01/1995", dtf), new BigDecimal(2234.68) , "Recepcionista");
		funcionarios.add(func5);
		Funcionário func6 = new Funcionário("Heitor", LocalDate.parse("19/11/1999", dtf), new BigDecimal(1582.72) , "Operador");
		funcionarios.add(func6);
		Funcionário func7 = new Funcionário("Arthur", LocalDate.parse("31/03/1993", dtf), new BigDecimal(4071.84) , "Contador");
		funcionarios.add(func7);
		Funcionário func8 = new Funcionário("Laura", LocalDate.parse("08/07/1994", dtf), new BigDecimal(3017.45) , "Gerente");
		funcionarios.add(func8);
		Funcionário func9 = new Funcionário("Heloísa", LocalDate.parse("24/05/2003", dtf), new BigDecimal(1606.85) , "Eletricista");
		funcionarios.add(func9);
		Funcionário func10 = new Funcionário("Helena", LocalDate.parse("02/09/1996", dtf), new BigDecimal(2799.93) , "Gerente");
		funcionarios.add(func10);
		
		
		
				
		//Impressão dos funcionários conforme item 3.1
		System.out.println("TESTE PRÁTICO PROJEDATA - AUTOR: NELSON LUIZ SILVA FERREIRA");
		System.out.println();
		System.out.println();
		
		System.out.println("3.1 - Inserção e listagem dos funcionários conforme tabela!");
		for (Funcionário x : funcionarios) {
			System.out.println(x.getNome() + " - " + x.getDataNascimento().format(dtf) + " - R$" + decimalFormat.format(x.getSalario()) + " - " + x.getFuncao());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.2 - Remover João e 3.3 apresentar os dados em tela
		funcionarios.removeIf(x -> x.getNome().equals("João"));
		System.out.println("3.2 e 3.3 - Impressão dos funcionários, após a remoção do João!");
		for (Funcionário x : funcionarios) {
			System.out.println(x.getNome() + " - " + x.getDataNascimento().format(dtf) + " - R$" + decimalFormat.format(x.getSalario()) + " - " + x.getFuncao());
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.4 - Aumento de 10% no salário dos funcionários
		System.out.println("3.4 - Aumento de salário em 10% para os funcionários!");
		for (Funcionário x : funcionarios) {
			x.aumentoSalario(); //criado método para aumentar em 10% o salário dos funcionários
			System.out.println(x.getNome() + " - " + x.getDataNascimento().format(dtf) + " - R$" + decimalFormat.format(x.getSalario()) + " - " + x.getFuncao());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.5 - Agrupar os funcionários por função em um MAP, sendo a chave "função" e o valor a "lista de funcionários"
		//Não entendi muito bem como deveria ser a saída desse item, logo, apenas inseri em um Map e apresentei em tela
		System.out.println("3.5 - Agrupar os funcionários por função em um MAP!");
		Map<String, List> map = new HashMap<>();
		for (Funcionário x : funcionarios) {
			map.put(x.getFuncao(), funcionarios);
		}
		for(String chave : map.keySet()) {
			System.out.println(chave + ": " + map.get(chave));
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.6 - Imprimir os funcionários agrupados por função
		
		
		//3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12
		System.out.println("3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12!");
		for (Funcionário x : funcionarios) {
			if(x.getDataNascimento().getMonthValue() == 10 || x.getDataNascimento().getMonthValue() == 12) {
				System.out.println(x.getNome() + " - " + x.getDataNascimento().format(dtf) + " - R$" + decimalFormat.format(x.getSalario()) + " - " + x.getFuncao());
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.9 - Imprimir o funcionário com a maior idade, exibir os atributos nome e idade
		System.out.println("3.9 - Imprimir o funcionário com a maior idade, exibir os atributos nome e idade!");
		Pessoa menorData = Collections.min(funcionarios, Comparator.comparing(Pessoa::getDataNascimento)); //tem como objetivo retornar o objeto que possui a menor data, ou seja, trazer o objeto em que possui o funcionário de maior idade
		for (Funcionário x : funcionarios) {
			if(x.getDataNascimento() == menorData.getDataNascimento()) {
				long idade = ChronoUnit.YEARS.between(menorData.getDataNascimento(), LocalDate.now()); 
				System.out.println(x.getNome() + " - " + idade + " anos");
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();		
		
		//3.10 - Imprimir a lista de funcionários por ordem alfabética
		System.out.println("3.10 - Imprimir a lista de funcionários por ordem alfabética!");
		List<String> listaNomes = new ArrayList<>();
		for(Pessoa x : funcionarios) {
			String nome = x.getNome();
			listaNomes.add(nome); //Gera uma lista apenas com os nomes
		}
		Collections.sort(listaNomes); //Ordena a lista alfabeticamente
		//para cada funcionário existente na lista ordenada, buscará na lista de funcionários e retornar os dados do mesmo
		for(String pes : listaNomes) {
			for(Funcionário x : funcionarios) {
				if(x.getNome() == pes) {
					System.out.println(x.getNome() + " - " + x.getDataNascimento().format(dtf) + " - R$" + decimalFormat.format(x.getSalario()) + " - " + x.getFuncao());
				}
			}
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//3.11 - Imprimir o total dos salários dos funcionários
		System.out.println("3.11 - Imprimir o total dos salários dos funcionários!");
		BigDecimal totalSalario = BigDecimal.ZERO;
		for (Funcionário x : funcionarios) {
			totalSalario = totalSalario.add(x.getSalario());
		}
		System.out.println("Salário total(contendo o aumento de 10%) = R$" + decimalFormat.format(totalSalario));		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//3.12 - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212,00
		System.out.println("3.12 - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212,00 (considerando o aumento de 10%)!");
		for (Funcionário x : funcionarios) {
			System.out.println(x.getNome() + " - " + String.format("%.2f", x.quantidadeSalarioMinimo(x.getSalario())) + " salários mínimos"); //criado método quantidadeSalarioMinimo 
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		sc.close();

	}

	
}
