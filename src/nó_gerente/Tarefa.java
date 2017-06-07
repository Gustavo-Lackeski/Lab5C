package nó_gerente;
import java.util.ArrayList;

public class Tarefa {
	private long HoraCriaçãoTarefa;
	private int TempodeCPUNecessário;
	public Tarefa(long criacao, int tempo){
		this.HoraCriaçãoTarefa = criacao;
		this.TempodeCPUNecessário = tempo;
	}
	public int getTempo(){
		return this.TempodeCPUNecessário;
	}

}
