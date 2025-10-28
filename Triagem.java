package kaka1;

import java.util.List;
import java.time.LocalDateTime;

public class Triagem {

	private int id;
	private Funcionario enfermeiro;
	private Pessoa paciente;
	private Classificacao classificacao;
	private LocalDateTime historicoAtendimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Funcionario enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public Pessoa getPaciente() {
		return paciente;
	}

	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public LocalDateTime getHistoricoAtendimento() {
		return historicoAtendimento;
	}

	public void setHistoricoAtendimento(LocalDateTime historicoAtendimento) {
		this.historicoAtendimento = historicoAtendimento;
	}

	public String definirClassificacao() {
		enfermeiro = this.getEnfermeiro();
		List<String> respostas = enfermeiro.atenderPaciente();

		//calcula pontos para classificar
		int pontos = 0;
		//se maior de idade
		if(this.getPaciente().calcularIdade() < 18) {
			pontos += 1;
		}

		//se dor maior que 4
		if(Integer.parseInt(respostas.get(0)) >= 5) {
			pontos += 1;
		}

		//se teve febre, calafrios, tosse ou falta de ar
		if(respostas.get(1).equalsIgnoreCase("sim")) {
			pontos += 1;
		}

		// se teve teve sangramentos ou outras perdas de sangue
		if(respostas.get(2).equalsIgnoreCase("sim")) {
			pontos += 1;
		}

		// se os sintomas começaram a mais de 4 dias
		if(Integer.parseInt(respostas.get(3)) >= 5) {
			pontos += 1;
		}
		String classificacao="";
		switch (pontos) {
			case 0:
				classificacao = "não urgente";
				break;
			case 1:
				classificacao = "pouco urgente";
				break;
			case 2:
			case 3:
				classificacao = "urgente";
				break;
			case 4:
			case 5:
				classificacao = "emergencia";
				break;
		}
		
		return classificacao;
	}
}
