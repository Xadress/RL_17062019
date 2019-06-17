package ccloader.application.creditcards.model;

import java.util.Date;

public class CreditCard {

	private CreditCardNumber cardNumber;
	private String bankName;
	private Date expiryDate;
	
	public CreditCard(CreditCardNumber cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}
	
	public CreditCardNumber getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(CreditCardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null) {
				return false;
			}
		} else if (!cardNumber.equals(other.cardNumber)) {
			return false;
		}
		return true;
	}
	
	
}
