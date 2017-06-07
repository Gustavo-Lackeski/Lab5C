package ReceptoreEmissor;
import java.util.ArrayList;

public class Tarefa {
	private int NúmeroCPUqueCriou;
	private long HoraCriaçãoTarefa;
	private int TempodeCPUNecessário;
	public Tarefa(int CPU, long criacao, int tempo){
		this.NúmeroCPUqueCriou = CPU;
		this.HoraCriaçãoTarefa = criacao;
		this.TempodeCPUNecessário = tempo;
	}
	public int getTempo(){
		return this.TempodeCPUNecessário;
	}

}
