package n�_gerente;
import java.util.ArrayList;

public class Tarefa {
	private long HoraCria��oTarefa;
	private int TempodeCPUNecess�rio;
	public Tarefa(long criacao, int tempo){
		this.HoraCria��oTarefa = criacao;
		this.TempodeCPUNecess�rio = tempo;
	}
	public int getTempo(){
		return this.TempodeCPUNecess�rio;
	}

}
