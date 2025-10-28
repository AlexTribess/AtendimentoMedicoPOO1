package kaka1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtendimentoMain {

    private final List<Atendimento> historicoAtendidos;
    private final List<Triagem> historicoTriagem;
    private int proximoPacienteId;
    
    private final Funcionario enfermeiro;
    private final Funcionario medico;
    private final Classificacao vermelho;
    private final Classificacao amarelo;
    private final Classificacao verde;
    private final Classificacao azul;
    private final Fila filaPacientes;

    public AtendimentoMain() {
        this.historicoAtendidos = new ArrayList<>();
        this.historicoTriagem = new ArrayList<>();
        this.proximoPacienteId = 1;

        Funcao funcaoEnfermeiro = new Funcao(1, "Enfermeiro", "Triagem");
        Funcao funcaoMedico = new Funcao(2, "Médico", "Clínico Geral");

        this.enfermeiro = new Funcionario(1, funcaoEnfermeiro);
        this.enfermeiro.setNome("Ana Silva");
        this.enfermeiro.setCpf("000.000.000-00");
        this.medico = new Funcionario(2, funcaoMedico);
        this.medico.setNome("Dr. João Souza");
        this.medico.setCpf("111.111.111-11");
        this.vermelho = new Classificacao(5, "Emergência (Atendimento Imediato)", Duration.ofMinutes(0));
        this.amarelo = new Classificacao(3, "Urgente (Até 20 min)", Duration.ofMinutes(20));
        this.verde = new Classificacao(2, "Pouco Urgente (Até 120 min)", Duration.ofMinutes(120));
        this.azul = new Classificacao(1, "Não Urgente (Até 3 horas)", Duration.ofHours(3));

        this.filaPacientes = new Fila(1, new ArrayList<>());
    }
    
    public static void main(String[] args) {
        AtendimentoMain app = new AtendimentoMain();
        app.run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int op = -1;

        do {
            try {
                System.out.println("\n====================");
                System.out.println("Opções do Sistema");
                System.out.println("1 - Atender próximo paciente (Médico)");
                System.out.println("2 - Cadastrar e Triar novo paciente (Enfermeiro)");
                System.out.println("3 - Visualizar histórico de atendimentos");
                System.out.println("4 - Ver fila de espera");
                System.out.println("0 - Encerrar");
                System.out.println("====================");
                System.out.print("Escolha uma opção: ");

                if (input.hasNextInt()) {
                    op = input.nextInt();
                } else {
                    System.out.println("Opção inválida. Digite um número.");
                    input.next(); 
                    op = -1;
                    continue;
                }
                input.nextLine(); 

                switch (op) {
                    case 1:
                        chamarProximoPaciente();
                        break;
                    case 2:
                        cadastrarNovoPaciente(input);
                        break;
                    case 3:
                        visualizarHistorico();
                        break;
                    case 4:
                        verFila();
                        break;
                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Ocorreu um erro no sistema: " + e.getMessage());
            }
        } while (op != 0);

        input.close();
    }


    private void chamarProximoPaciente() {
        if (filaPacientes.getPacientes().isEmpty()) {
            System.out.println("A fila de pacientes está vazia.");
            return;
        }

        Paciente pacienteAtendido = filaPacientes.getPacientes().remove(0); 
        
        Atendimento novoAtendimento = new Atendimento();
        novoAtendimento.setId(historicoAtendidos.size() + 1);
        novoAtendimento.setPaciente(pacienteAtendido);
        novoAtendimento.setMedico(medico);

        historicoAtendidos.add(novoAtendimento);

        System.out.println("\n--- CHAMADA DE ATENDIMENTO ---");
        System.out.println("Próximo paciente: " + pacienteAtendido.getNome() + " (ID: " + pacienteAtendido.getId() + ")");
        System.out.println("Classificação: " + pacienteAtendido.getNivel().getDescricao());
        System.out.println("Encaminhado para atendimento com Dr. " + medico.getNome());
        System.out.println("-----------------------------");
    }

    private void cadastrarNovoPaciente(Scanner input) {
        System.out.println("\n--- CADASTRO DE PACIENTE ---");
        Paciente paciente = new Paciente(proximoPacienteId++, null, null);

        System.out.print("Nome completo: ");
        paciente.setNome(input.nextLine());

        System.out.print("CPF (formato 000.000.000-00): ");
        paciente.setCpf(input.nextLine());
        
        LocalDate dataNascimento = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (dataNascimento == null) {
            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            String dataString = input.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataString, formatter);
                paciente.setDataNascimento(dataNascimento);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            }
        }
        
        System.out.println("\n--- TRIAGEM (POR " + enfermeiro.getNome() + ") ---");
        List<String> respostas = new ArrayList<>();
        
        System.out.print("De 0 a 10, qual o nível da sua dor? ");
        respostas.add(input.nextLine());

        System.out.print("Você teve febre, calafrios, tosse ou falta de ar? (sim/nao): ");
        respostas.add(input.nextLine());

        System.out.print("Você teve sangramentos ou outras perdas de sangue? (sim/nao): ");
        respostas.add(input.nextLine());

        System.out.print("Há quantos dias os sintomas começaram? ");
        respostas.add(input.nextLine());
        
        paciente.setPerguntas(respostas); 
        
        Triagem triagem = new Triagem();
        triagem.setEnfermeiro(enfermeiro);
        triagem.setPaciente(paciente);
        
        int pontos = 0;
        
        if (paciente.calcularIdade() < 18) {
            pontos += 1;
        }

        try {
            if (Integer.parseInt(respostas.get(0).trim()) >= 5) {
                pontos += 1;
            }
        } catch (NumberFormatException ignored) {}

        if (respostas.get(1).trim().equalsIgnoreCase("sim")) {
            pontos += 1;
        }

        if (respostas.get(2).trim().equalsIgnoreCase("sim")) {
            pontos += 1;
        }

        try {
            if (Integer.parseInt(respostas.get(3).trim()) >= 5) {
                pontos += 1;
            }
        } catch (NumberFormatException ignored) {}
        
        Classificacao nivel;
        if (pontos >= 4) {
            nivel = vermelho;
        } else if (pontos == 3) {
            nivel = amarelo;
        } else if (pontos == 2) {
            nivel = verde;
        } else {
            nivel = azul;
        }
        
        paciente.setNivel(nivel);
        triagem.setClassificacao(nivel);
        triagem.setHistoricoAtendimento(java.time.LocalDateTime.now());

        System.out.println("\n--- RESULTADO DA TRIAGEM ---");
        System.out.println("Paciente: " + paciente.getNome() + " (" + paciente.calcularIdade() + " anos)");
        System.out.println("Pontos de Risco: " + pontos + " | Classificação: " + nivel.getDescricao());
        System.out.println("Tempo de espera estimado: " + nivel.getTempoEspera().toMinutes() + " minutos.");
        System.out.println("----------------------------");

        filaPacientes.adicionarPaciente(paciente);
        historicoTriagem.add(triagem);

        System.out.println("Paciente adicionado à fila com sucesso!");
    }

    private void visualizarHistorico() {
        System.out.println("\n--- HISTÓRICO DE ATENDIMENTOS REALIZADOS ---");
        if (historicoAtendidos.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            for (Atendimento at : historicoAtendidos) {
                System.out.println("ID Atendimento: " + at.getId() + " | Paciente: " + at.getPaciente().getNome() +
                                   " | Médico: " + at.getMedico().getNome() +
                                   " | Nível: " + at.getPaciente().getNivel().getDescricao());
            }
        }
        
        System.out.println("\n--- LISTA DE PACIENTES NA FILA (TRIAGENS PENDENTES) ---");
        List<Paciente> pacientesNaFila = filaPacientes.getPacientes();
        if (pacientesNaFila.isEmpty()) {
             System.out.println("A fila está vazia.");
        } else {
             for (Paciente p : pacientesNaFila) {
                 System.out.println("ID Paciente: " + p.getId() + " | Nome: " + p.getNome() + 
                                    " | Nível: " + p.getNivel().getDescricao());
             }
        }
    }

    private void verFila() {
        List<Paciente> pacientes = filaPacientes.getPacientes();
        System.out.println("\n--- FILA DE ESPERA ---");
        if (pacientes.isEmpty()) {
            System.out.println("A fila está vazia. Nenhum paciente esperando.");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente p = pacientes.get(i);
                System.out.println((i + 1) + "º: ID " + p.getId() + " - " + p.getNome() + 
                                   " - Classificação: " + p.getNivel().getDescricao());
            }
            System.out.print("Próximo a ser chamado: ");
            filaPacientes.chamarProximo();
        }
    }
}