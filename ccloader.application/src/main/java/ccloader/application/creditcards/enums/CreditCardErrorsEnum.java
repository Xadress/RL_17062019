package ccloader.application.creditcards.enums;

public enum CreditCardErrorsEnum {
	
	MALFORMEND_CC_NUMBER("Credit card number malformed: It should be 16 digits long.");
	
	private String value;
	
	private CreditCardErrorsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
