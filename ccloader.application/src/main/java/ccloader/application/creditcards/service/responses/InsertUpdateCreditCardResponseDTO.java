package ccloader.application.creditcards.service.responses;

import java.util.ArrayList;
import java.util.List;

import ccloader.application.common.dto.BaseDTO;
import ccloader.application.creditcards.dto.CreditCardDTO;

/**
 * Response for credit card insertion service
 * @author Raffaele
 *
 */
public class InsertUpdateCreditCardResponseDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361845651157431003L;
	
	private List<CreditCardDTO> insertedCCs = new ArrayList<>();
	private List<CreditCardDTO> discardedCCs = new ArrayList<>();

	@Override
	public boolean isValid() {
		return true;
	}

	public List<CreditCardDTO> getInsertedCCs() {
		return insertedCCs;
	}

	public void setInsertedCCs(List<CreditCardDTO> insertedCCs) {
		this.insertedCCs = insertedCCs;
	}

	public List<CreditCardDTO> getDiscardedCCs() {
		return discardedCCs;
	}

	public void setDiscardedCCs(List<CreditCardDTO> discardedCCs) {
		this.discardedCCs = discardedCCs;
	}

}
