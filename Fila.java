package kaka1;
import java.util.List;

public class Fila {

	private int id;
	private List<Paciente> pacientes;
		
	public Fila(int id, List<Paciente> pacientes) {
		super();
		this.id = id;
		this.pacientes = pacientes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void adicionarPaciente(Paciente paciente){
		pacientes.add(paciente);	
		return true;
	}
	
	public void chamarProximo() {
		paciente = pacientes.getFirst();	
		System.out.println("Atendimento de " + paciente);
		return true;
	}
}
