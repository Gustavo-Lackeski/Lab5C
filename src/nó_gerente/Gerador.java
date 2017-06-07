package nó_gerente;
import java.util.ArrayList;
import java.util.Random;

public class Gerador {
	private Gerente ger;
	private int N;
	private int TMT;
	private int Amount;
	private boolean gerando;
	private int clockAtual;
	public Gerador(int n, int tmt, int amount,Gerente g ){
		this.N = n;
		this.TMT = tmt;
		this.Amount = amount;
		gerando = false;
		clockAtual = 0;
		ger = g;
	}
	
	public void update(){
		clockAtual++;
		if(clockAtual==TMT){
			clockAtual = 0;
			for (int i = 0;i<Amount;i++){
				Tarefa temp = new Tarefa(System.currentTimeMillis() ,TMT);
				ger.addTarefa(temp);
			}
			
		}
	}
}
