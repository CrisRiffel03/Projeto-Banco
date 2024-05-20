package projetoBanco;

import java.io.InputStream;
import java.util.Scanner;

public class ProjetoBanco {

	public static void main(String[] args) {
	

		Conta c1 = new ContaPagamento();
		Conta c2 = new ContaPoupanca();
		
		c1.nomeTitular = "Cristiano";
		c1.numConta = 1;
		
		c2.nomeTitular = "Júlia";
		c2.numConta = 2;
		
		
		c1.depositar(50);
		System.out.println("Titular da conta é: " + c1.nomeTitular);
		System.out.println("Saldo da conta Pagamento é: " + c1.getSaldo());
		
		
		System.out.println();
		
		c2.depositar(50);
		System.out.println("Titular da conta é: " + c2.nomeTitular);
		System.out.println("Saldo da conta Poupança é: " + c2.getSaldo());
		
		System.out.println();
		
		c1.transferir(c2, 20);
		System.out.println("Saldo da conta Pagamento após a transferência é: " + c1.getSaldo());
		System.out.println("Saldo da conta Poupança após a transferência é: " + c2.getSaldo());
		
		System.out.println();
		
		c2.sacar(30);
		System.out.println("Saldo da conta Poupança após o saque é: " + c2.getSaldo());
		
	}
}



class Conta{
	public String nomeTitular;
	public int numConta;
	private double saldo;
	protected double taxaSaque = 0.0;
	
	public boolean depositar(double valor) {
		
		this.saldo = this.saldo + valor;
		return true;
	}
	
	public boolean sacar(double valor) {
		
		if (valor + this.taxaSaque <= this.saldo) {
			this.saldo = this.saldo - valor - this.taxaSaque;
			System.out.println("Operação realizada com sucesso!");
			return true;			
		}else {
			System.out.println("Saldo insuficiente!");
			return false;
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public boolean transferir(Conta contaDestino, double valor) {
		
		if (this.sacar(valor) == true) {
			contaDestino.depositar(valor);
			return true;
		}else {
			return false;
		}
	}
}	
	
class ContaPagamento extends Conta{
		
		public boolean sacar (double valor) {
			super.taxaSaque = 1.0;
			return super.sacar(valor);
		}
	}
	
class ContaPoupanca extends Conta{
		
		public boolean sacar (double valor) {
			super.taxaSaque = 0.0;
			return super.sacar(valor);
		}
}
	



	