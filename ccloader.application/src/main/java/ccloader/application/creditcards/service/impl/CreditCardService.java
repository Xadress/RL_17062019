package ccloader.application.creditcards.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ccloader.application.common.PagedList;
import ccloader.application.common.service.BaseService;
import ccloader.application.creditcards.dto.CreditCardDTO;
import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.creditcards.service.interf.ICreditCardCommandRepository;
import ccloader.application.creditcards.service.interf.ICreditCardQueryRepository;
import ccloader.application.creditcards.service.interf.ICreditCardService;
import ccloader.application.creditcards.service.responses.InsertUpdateCreditCardResponseDTO;

@Service
public class CreditCardService extends BaseService implements ICreditCardService{
	
	@Autowired
	private ICreditCardQueryRepository creditCardQueryRepo;
	
	@Autowired
	private ICreditCardCommandRepository creditCardCommandRepo;
	
	@Override
	public PagedList<CreditCardDTO> getCreditCardsPaged(int page){
		
		List<CreditCard> ccList = creditCardQueryRepo.getCreditCardsByUser(getCurrentUser());
		
		//Sort ccList by expiry date in descending order
		Collections.sort(ccList, (a, b) -> b.getExpiryDate().compareTo(a.getExpiryDate()));
		
		PagedList<CreditCardDTO> result = new PagedList<>(mapper.mapAsList(ccList, CreditCardDTO.class));
		result.setPageNumber(page);
		
		return result;
	}
	
	@Override
	public InsertUpdateCreditCardResponseDTO insertUpdateCreditCards(List<CreditCardDTO> ccDtoList){
		InsertUpdateCreditCardResponseDTO response = validateCreditCardInsertion(ccDtoList);
		List<CreditCard> ccToInsert = mapper.mapAsList(response.getInsertedCCs(), CreditCard.class);
		
		for(CreditCard c : ccToInsert) {
			creditCardCommandRepo.insertUpdateCreditCard(c, getCurrentUser());
		}
		
		return response;
	}
	
	private InsertUpdateCreditCardResponseDTO validateCreditCardInsertion(List<CreditCardDTO> ccList) {
		InsertUpdateCreditCardResponseDTO response = new InsertUpdateCreditCardResponseDTO();
		
		ccList.forEach(p -> {
			if(p.isValid()) {
				response.getInsertedCCs().add(p);
			}else {
				response.getDiscardedCCs().add(p);
			}
		});
		
		return response;
	}
	
}
