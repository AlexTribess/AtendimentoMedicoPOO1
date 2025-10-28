import java.time.Duration;
import java.util.List;

public class Classificacao {

	private String cor;
	private String descricao;
	private Duration tempoEspera;

	public Classificacao(String cor, String descricao, Duration tempoEspera) {
		super();
		this.cor = cor;
		this.descricao = descricao;
		this.tempoEspera = tempoEspera;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Duration getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(Duration tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	private int calcularPontuacao(List<String> respostas) {
		int pontuacao = 0;

		String q1 = respostas.get(0).toLowerCase();
		if (q1.contains("grave") || q1.contains("inconsciente") || q1.contains("sangramento incontrolável")) {
			pontuacao += 10;
		} else if (q1.contains("moderado") || q1.contains("confuso")) {
			pontuacao += 5;
		}

		String q2 = respostas.get(1).toLowerCase();

		if (q2.contains("intensa") || q2.contains("8") || q2.contains("9") || q2.contains("10")) {
			pontuacao += 8;
		} else if (q2.contains("moderada") || q2.contains("4") || q2.contains("5") || q2.contains("6")
				|| q2.contains("7")) {
			pontuacao += 3;
		}

		// adicionem mais perguntas
		
		return pontuacao;
	}

	private void definirRisco(int pontuacao) {

		if (pontuacao >= 20) {
			this.cor = "VERMELHO";
			this.descricao = "EMERGÊNCIA - Atendimento Imediato";
			this.tempoEspera = Duration.ofMinutes(0);
		} else if (pontuacao >= 15) {
			this.cor = "AMARELO";
			this.descricao = "URGENTE - Atendimento em até 20 minutos";
			this.tempoEspera = Duration.ofMinutes(20);
		} else if (pontuacao >= 8) {
			this.cor = "VERDE";
			this.descricao = "POUCO URGENTE - Atendimento em até 120 minutos";
			this.tempoEspera = Duration.ofHours(2);
		} else {
			this.cor = "AZUL";
			this.descricao = "NÃO URGENTE - Atendimento em até 03 horas";
			this.tempoEspera = Duration.ofHours(3);
		}
	}

	public int getPrioridadeNumerica() {
		switch (this.cor.toUpperCase()) {
		case "VERMELHO":
			return 1;
		case "AMARELO":
			return 2;
		case "VERDE":
			return 3;
		case "AZUL":
			return 4;
		default:
			return 5;
		}
	}

	public void classificarCliente(List<String> respostas) {
		int pontuacao = 0;
		pontuacao = calcularPontuacao(respostas);
		definirRisco(pontuacao);
	}

}
