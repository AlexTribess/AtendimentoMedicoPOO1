package kaka1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {

	private int id;
	private Funcao funcao;
		
	public Funcionario(int id, Funcao funcao) {
		super();
		this.id = id;
		this.funcao = funcao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	public List<String> atenderPaciente(){
		Scanner input = new Scanner(System.in);

		List<String> respostas = new ArrayList<>();

		System.out.println("De 0 a 10, qual o nivel da sua dor?");
		respostas.add(input.nextLine());

		System.out.println("Você teve febre, calafrios, tosse ou falta de ar?");
	    respostas.add(input.nextLine());

		System.out.println("Você teve sangramentos ou outras perdas de sangue?");
		respostas.add(input.nextLine());

		System.out.println("Há quantos dias os sintomas começaram?");
		respostas.add(input.nextLine());

		
		input.close();
		return respostas;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [id=");
		builder.append(id);
		builder.append(", funcao=");
		builder.append(funcao);
		builder.append("]");
		return builder.toString();
	}
	
}
