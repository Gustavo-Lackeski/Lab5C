package Receptor;
import java.util.ArrayList;
import java.util.Random;

public class CPU {
	private int sondagensRecebidas,sondagensEnviadas;
	private int id;
	private int N;
	private boolean busy;
	private ArrayList<CPU> processadores = new ArrayList<CPU>();
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Tarefa realizando;
	private int clockAtual;
	public CPU(int iden, int n){
		this.sondagensEnviadas = 0;
		this.sondagensRecebidas = 0;
		this.id = iden;
		busy = false;
		clockAtual = 0;
		this.N = n;
	}
	public void setProc(ArrayList<CPU> proc){
		this.processadores = proc;
	}
	public void addTarefa(Tarefa e){
		this.tarefas.add(e);
	}
	public boolean isBusy(){
		return this.busy;
	}
	public void update(){
		if(!busy){
			if(tarefas.isEmpty()){
				//iniciar algoritmo receptor
				this.escalonarReceptor();
			}
			//se tiver tarefa a ser realizada,comecar a executar
			if(!tarefas.isEmpty()){
				clockAtual++;
				realizando = tarefas.get(0);
				tarefas.remove(0);
				busy = true;
				if(clockAtual==realizando.getTempo()){
					clockAtual = 0;
					busy = false;
					realizando = null;
				}
			}
		}
		//se estiver ocupado
		else{			
			//continuar a executar a tarefa
			clockAtual++;
			if(clockAtual==realizando.getTempo()){
				clockAtual = 0;
				busy = false;
				realizando = null;
			}
			
		}
	}
	public void incSondRecebida(){
		this.sondagensRecebidas++;
	}
	private void escalonarReceptor(){
		Random rn = new Random();
		boolean achou = false;
		int i = 0;
		while (!achou && i < N){
			int index = rn.nextInt(N);
			//caso o CPU escolhido nao seja o mesmo
			if (index!=id){
				this.sondagensEnviadas++;
				CPU p = processadores.get(index);
				p.incSondRecebida();
				//se  tiver ocupado e tem tarefa pendente, retirar tarefa de p
				if (p.isBusy() && p.hasPendingTask()){
					achou = true;
					this.tarefas.add(p.getPendingTask());
				}
			}
			i++;
		}
	}
	public boolean hasPendingTask(){
		return !this.tarefas.isEmpty();
	}
	public Tarefa getPendingTask(){
		Tarefa temp = tarefas.get(0);
		tarefas.remove(0);
		return temp;
	}
	public void printMens(){
		System.out.println("CPU "+ id + ": Mens recebidas: "+this.sondagensRecebidas + " Mens enviadas:" + this.sondagensEnviadas);
	}

}
