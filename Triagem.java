package kaka1;
import java.util.ArrayList;
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

	public void definirClassificacao() {
		enfermeiro = self.getEnfermeiro();
		List<String> respostas = enfermeiro.atenderPaciente();

		//calcula pontos para classificar
		pontos = 0
		//se maior de idade
		if(self.getPaciente().calcularIdade() < 18) {
			pontos + 1;
		}

		//se dor maior que 4
		if(Integer.parseInt(respostas.get(0)) >= 5) {
			pontos + 1;
		}

		//se teve febre, calafrios, tosse ou falta de ar
		if(respostas.get(1).equalsIgnoreCase("sim")) {
			pontos + 1;
		}

		// se teve teve sangramentos ou outras perdas de sangue
		if(respostas.get(2).equalsIgnoreCase("sim")) {
			pontos + 1;
		}

		// se os sintomas começaram a mais de 4 dias
		if(Integer.parseInt(respostas.get(3)) >= 5) {
			pontos + 1;
		}

		switch (pontos) {
			case 0:
				'não urgente';
				break;
			case 1:
				'pouco urgente';
				break;
			case 2, 3:
				'urgente';
				break;
			case 4, 5:
				'emergencia';
				break;
		}
	}
}
