package ReceptoreEmissor;
import java.util.ArrayList;

public class Tarefa {
	private int N�meroCPUqueCriou;
	private long HoraCria��oTarefa;
	private int TempodeCPUNecess�rio;
	public Tarefa(int CPU, long criacao, int tempo){
		this.N�meroCPUqueCriou = CPU;
		this.HoraCria��oTarefa = criacao;
		this.TempodeCPUNecess�rio = tempo;
	}
	public int getTempo(){
		return this.TempodeCPUNecess�rio;
	}

}
