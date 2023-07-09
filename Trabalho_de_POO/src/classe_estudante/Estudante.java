package classe_estudante;


public class Estudante {
	private String nome; 
	private float nota; 
	private String exc = null;
	private double Renda;
	private String Etnia;
	private boolean Deficiencia;
	private String EscolaPublica;
	public Estudante(String nome, float nota, double renda, String etnia, boolean deficiencia,
			String escolaPublica) {
		this.nome = nome;
		this.nota = nota;
		this.Renda = renda;
		this.Etnia = etnia;
		this.Deficiencia = deficiencia;
		this.EscolaPublica = escolaPublica;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public float getNota() {
		return this.nota;
	}

	public String getExc() {
		return exc;
	}

	public void setExc(String exc) {
		this.exc = exc;
	}

	public double getRenda() {
		return Renda;
	}

	public void setRenda(double renda) {
		Renda = renda;
	}

	public String getEtnia() {
		return Etnia;
	}

	public void setEtnia(String etnia) {
		Etnia = etnia;
	}

	public boolean isDeficiencia() {
		return Deficiencia;
	}

	public void setDeficiencia(boolean deficiencia) {
		Deficiencia = deficiencia;
	}

	public String isEscolaPublica() {
		return EscolaPublica;
	}

	public void setEscolaPublica(String escolaPublica) {
		EscolaPublica = escolaPublica;
	}
	
	@Override
	public String toString() {
		return getNome() + "-" + getNota();
	}

}
