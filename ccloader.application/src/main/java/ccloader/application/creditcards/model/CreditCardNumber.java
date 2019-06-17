package ccloader.application.creditcards.model;

import java.util.Arrays;

/**
 * Contains the four parts of a credit card.
 * Numbers contained are sensible data, so they are stored as int[] to make them stringPool safe. <br>
 * <b>Assumption</b> all credit card numbers have fixed length of 16 digits.
 * @author Raffaele
 *
 */
public class CreditCardNumber {
	
	private final String MASK_CHAR = "x";
	private final String NUM_SEPARATOR = "-";
	
	private int[] number;
	
	public CreditCardNumber(int[] input) {
		super();
		this.number = input!=null ?  input : new int[16];
	}
	
	public CreditCardNumber(String input) {
		super();
		if(input!=null) {
			this.number = new int[input.length()]; 
			int i = 0;
			for(char c : input.toCharArray()) {
				number[i] = Integer.parseInt(String.valueOf(c));
				i++;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int digitCount = 0;
		int i = 0;
		for(int n : this.number) {
			sb.append(n);
			digitCount++;
			i++;
			if(digitCount==4 && i < this.number.length) {
				sb.append(NUM_SEPARATOR);
				digitCount = 0;
			}
		}
		return sb.toString();
	}
	
	public String getMaskedCardNumber() {
		
		StringBuilder sb = new StringBuilder();
		int digitCount = 0;
		int i = 0;
		for(int n : this.number) {
			
			sb.append(i<4 ? n : MASK_CHAR);
			digitCount++;
			i++;
			
			if(digitCount == 4 && i < this.number.length) {
				sb.append(NUM_SEPARATOR);
				digitCount = 0;
			}
			
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(number);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		CreditCardNumber other = (CreditCardNumber) obj;
		return Arrays.equals(number, other.number);
	}


	
	
	

}
