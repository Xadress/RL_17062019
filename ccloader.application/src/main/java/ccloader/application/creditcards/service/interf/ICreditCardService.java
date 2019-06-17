package ccloader.application.creditcards.service.interf;

import java.util.List;

import ccloader.application.common.PagedList;
import ccloader.application.creditcards.dto.CreditCardDTO;
import ccloader.application.creditcards.service.responses.InsertUpdateCreditCardResponseDTO;

public interface ICreditCardService {

	PagedList<CreditCardDTO> getCreditCardsPaged(int page);

	InsertUpdateCreditCardResponseDTO insertUpdateCreditCards(List<CreditCardDTO> ccList);

}
