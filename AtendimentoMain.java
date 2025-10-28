import java.time.LocalDate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AtendimentoMain {

	public static void main(String[] args) {
		System.out.println("--- Início do Sistema de Triagem ---");

        // 1. Configuração Inicial (Função, Classificação)
        // Cria uma função para o enfermeiro
        Funcao funcaoEnfermeiro = new Funcao(1, "Enfermeiro", "Triagem");

        // Cria um objeto Funcionario que será o enfermeiro
        // O Funcionario herda de Pessoa, então podemos setar nome e data de nascimento
        Funcionario enfermeiro = new Funcionario(101, funcaoEnfermeiro);
        enfermeiro.setNome("Ana Silva");
        enfermeiro.setDataNascimento(LocalDate.of(1990, 5, 15));
        
        // As classificações reais seriam criadas aqui e usadas para setar o campo nivel no Paciente.
        // Vamos criar uma classificação inicial (que será substituída pela triagem)
        Classificacao naoUrgente = new Classificacao(5, "Não Urgente", Duration.ofMinutes(120));


        // 2. Criação do Paciente
        // Cria uma Pessoa (Paciente) com dados básicos. O Paciente herda de Pessoa.
        Paciente paciente = new Paciente(1, naoUrgente, new ArrayList<>()); // Nível inicial
        paciente.setNome("João Mendes");
        // Para simular um paciente menor de 18 anos (para ganhar ponto na triagem)
        paciente.setDataNascimento(LocalDate.of(2010, 10, 28)); // Terá ~15 anos

        // 3. Início da Triagem
        // Cria um objeto Triagem e associa o enfermeiro e o paciente
        Triagem triagem = new Triagem();
        triagem.setEnfermeiro(enfermeiro);
        triagem.setPaciente(paciente);
        
        System.out.println("\n--- Simulação da Triagem ---");
        System.out.println("Enfermeiro(a): " + enfermeiro.getNome());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Idade do Paciente: " + paciente.calcularIdade() + " anos.");
        
        // Chamada ao método que irá interagir com o usuário (Scanner)
        // e calcular a classificação.
        // O fluxo do programa PARARÁ aqui e aguardará as respostas do console.
        
        System.out.println("\n*** ATENÇÃO: Responda as perguntas no console para continuar a simulação! ***");
        
        // A lógica do método 'definirClassificacao' (que precisa ser corrigida, pois ainda tem 'case 2, 3')
        // irá rodar e pedir a entrada do usuário.
        String classificacaoTexto = triagem.definirClassificacao();
        
        System.out.println("\n--- Resultado da Triagem ---");
        System.out.println("O paciente " + paciente.getNome() + " foi classificado como: " + classificacaoTexto.toUpperCase());
        
        // 4. Exemplo de uso de Fila
        System.out.println("\n--- Simulação de Fila ---");
        
        List<Paciente> listaPacientes = new ArrayList<>();
        Fila fila = new Fila(1, listaPacientes);
        
        fila.adicionarPaciente(paciente);
        System.out.println("Paciente " + paciente.getNome() + " adicionado à fila.");
        
        // Para simular a chamada, vamos assumir que a classificação foi armazenada
        // e o nível do paciente foi atualizado (isso exigiria lógica de mapeamento)
        // paciente.setNivel(novaClassificacao); // Se você tivesse criado um objeto Classificacao correspondente
        
        fila.chamarProximo(); // Apenas imprime o toString do paciente

        System.out.println("\n--- Fim do Sistema ---");
	}

}
