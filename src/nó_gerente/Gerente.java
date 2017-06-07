package nó_gerente;

import java.util.ArrayList;

public class Gerente {
	private ArrayList<CPU> processadores;
	private int N;
	private int TMT;
	private int Amount;
	private int tarefasRealocadas = 0;
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	public Gerente(ArrayList<CPU> p){
		this.processadores = p;
	}
	public int getTarefasRealocadas(){
		return this.tarefasRealocadas;
	}
	//DISTRIBUIR TAREFAS
	public void update(){
		boolean hasEmptyProcessor = true;
		while(!tarefas.isEmpty() && hasEmptyProcessor){
			hasEmptyProcessor = false;
			Tarefa t = tarefas.get(0);
			//procurar  nó desocupado
			for (CPU p:processadores)
				if(!p.isBusy()){
					hasEmptyProcessor = true;
					tarefasRealocadas++;
					p.addTarefa(t);
					tarefas.remove(t);
				}
		}
	}
	public void addTarefa(Tarefa t){
		this.tarefas.add(t);
	}
}
