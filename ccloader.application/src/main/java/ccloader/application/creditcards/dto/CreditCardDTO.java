package ccloader.application.creditcards.dto;

import java.util.Date;

import ccloader.application.common.IConvertibleItem;
import ccloader.application.common.StringUtils;
import ccloader.application.common.dto.BaseDTO;
import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.creditcards.model.CreditCardNumber;

/**
 * CreditCrad DTO class.
 * @author Raffaele
 *
 */
public class CreditCardDTO extends BaseDTO implements IConvertibleItem<CreditCard>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027153051942066310L;
	
	private String cardNumber;
	private String bankName;
	private Date expiryDate;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
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
	public boolean isValid() {
		boolean validCardNumber = !StringUtils.isNullOrEmpty(this.cardNumber) && this.cardNumber.matches("\\d+") && this.cardNumber.length()==16;
		boolean validBackName = !StringUtils.isNullOrEmpty(this.bankName);
		return validCardNumber && validBackName && this.expiryDate!=null;
	}

	@Override
	public void convertFrom(CreditCard model) {
		this.setBankName(model.getBankName());
		this.setCardNumber(model.getCardNumber()!=null ? model.getCardNumber().getMaskedCardNumber() : null);
		this.setExpiryDate(model.getExpiryDate());
	}

	@Override
	public CreditCard convertTo() {
		
		CreditCardNumber cardNumber2 = new CreditCardNumber(this.getCardNumber());
		CreditCard item = new CreditCard(cardNumber2);
		
		item.setBankName(this.getBankName());
		item.setExpiryDate(this.getExpiryDate());
		
		return item;
	}
}
