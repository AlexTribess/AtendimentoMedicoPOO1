import java.time.LocalDateTime;
import java.util.List;

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

	public void definirClassificacao(List<String> respostas) {
        
        
        if (respostas == null || respostas.isEmpty()) {
            System.err.println("Erro na Triagem: Respostas não fornecidas.");
            return;
        }
        this.paciente.setPerguntas(respostas);

        
        Classificacao novoNivel = new Classificacao();
        
        
        novoNivel.classificarCliente(respostas); 

        
        this.classificacao = novoNivel;
        this.paciente.setNivel(novoNivel);
        
        
        this.horarioTriagem = LocalDateTime.now();
        
        System.out.println("--- Triagem Concluída ---");
        System.out.println("Paciente: " + this.paciente.getNome());
        System.out.println("Enfermeiro: " + this.enfermeiro.getNome());
        System.out.println("Classificação: " + novoNivel.getCor() + " - " + novoNivel.getDescricao());
        System.out.println("Hora: " + this.horarioTriagem.toLocalTime());
    }
	
}
