package kaka1;

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

}
