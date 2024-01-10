package herencia;

public class Animal implements PuedeHablar {
protected int patas;

public int getPatas() {
	return patas;
}

public void setPatas(int patas) throws Exception {
	
	if (patas < 0) {
		throw new Exception("patas no puede ser negativo");
	} 
	this.patas = patas;
}

@Override
public void hablar() {
	// TODO Auto-generated method stub
	System.out.println("soy un animal");
}



}
