package Receptor;
import java.util.ArrayList;
import java.util.Random;

public class Gerador {
	private ArrayList<CPU> processadores;
	private int N;
	private int TMT;
	private int Amount;
	private boolean gerando;
	private int clockAtual;
	public Gerador(int n, int tmt, int amount,ArrayList<CPU> proc ){
		this.N = n;
		this.TMT = tmt;
		this.Amount = amount;
		gerando = false;
		clockAtual = 0;
		processadores = proc;
	}
	
	public void update(){
		clockAtual++;
		if(clockAtual==TMT){
			clockAtual = 0;
			Random rn = new Random();
			for (int i = 0;i<Amount;i++){
				int index = rn.nextInt(N);
				Tarefa temp = new Tarefa(index,System.currentTimeMillis() ,TMT);
				processadores.get(index).addTarefa(temp);
			}
			
		}
	}
}
