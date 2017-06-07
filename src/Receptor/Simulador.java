package Receptor;
import java.util.ArrayList;

public class Simulador {
	

	public static void main(String[] args) {
		final int N = 8;
		final int TMT  = 3;
		final int Amount  = 6;
		final int tempoSimulacao = 50*TMT;
		ArrayList<CPU> processadores = new ArrayList<CPU>();
		for (int i = 0;i<N;i++){
			CPU temp = new CPU(i,N);
			processadores.add(i, temp);
		}
		for (CPU p :processadores){
			p.setProc(processadores);
		}
		//alta carga
		Gerador gerGrande = new Gerador(N,TMT,Amount,processadores);
		for (int i = 0; i<tempoSimulacao;i++){
			gerGrande.update();
			for(CPU p:processadores){
				p.update();
			}
		}
		System.out.println("Receptor");
		System.out.println("Gerador de alta carga: ");
		for(CPU p:processadores){
			p.printMens();
		}
		//baixa carga
		processadores.clear();
		for (int i = 0;i<N;i++){
			CPU temp = new CPU(i,N);
			processadores.add(i, temp);
		}
		for (CPU p :processadores){
			p.setProc(processadores);
		}
		Gerador gerBaixo = new Gerador(N,TMT,Amount/3,processadores);
		for (int i = 0; i<tempoSimulacao;i++){
			gerBaixo.update();
			for(CPU p:processadores){
				p.update();
			}
		}
		System.out.println("Gerador de baixa carga: ");
		for(CPU p:processadores){
			p.printMens();
		}
	}

}
