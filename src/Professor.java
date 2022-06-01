


public class Professor { // criacao TAD

	
	int cpf;
	String nomeprof;
	double valor;
	int totaldeaulas;
	


public double  calcsalariobase() { // tinha colocado void mas n ha retorno
	
     double salprof; // double pq pode ter cents tbm
     
     salprof = valor * 4.5 * totaldeaulas;  // regra 1
     
     return salprof;
	
  }

public double horaatv() { // 2 regra 
	
	return calcsalariobase() * 0.05;
	
  }

public double descansoremunerado () { 
	
	return (calcsalariobase() + horaatv())/6;
  }

}