package blackjack.dominio;

public enum Palo {

	CORAZONES("❤️"),PICAS("♠️"),DIAMANTES("♦️"),TREBOLES("♣️");
	
	private String description;
	
	Palo(String description){
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
}
