package ccloader.repository.creditcards.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.creditcards.service.interf.ICreditCardCommandRepository;
import ccloader.application.creditcards.service.interf.ICreditCardQueryRepository;
import ccloader.application.user.model.User;
import ccloader.repository.common.BaseRepository;

@Repository
public class CreditCardRepository extends BaseRepository implements ICreditCardQueryRepository, ICreditCardCommandRepository{
	
	/**
	 * Instead of setting up a DB we will use a map to store unique credit cards for each user.
	 */
	private Map<String, Set<CreditCard>> creditCards = new HashMap<>();
	
	/**
	 * Returns all credit cards for a specific user.
	 */
	@Override
	public List<CreditCard> getCreditCardsByUser(User currentUser){
		Set<CreditCard> ccSet = creditCards.get(currentUser.getSessionId());
		return ccSet!=null ? new ArrayList<>(ccSet) : new ArrayList<>();
	}
	
	/**
	 * Adds a new credit card to the user list. If the card already exists it will be updated.
	 */
	@Override
	public void insertUpdateCreditCard(CreditCard newCc, User currentUser) {
		Set<CreditCard> ccSet = creditCards.get(currentUser.getSessionId());
		if(ccSet!=null) {
			if(!ccSet.add(newCc)) { //If present, replace
				ccSet.remove(newCc);
				ccSet.add(newCc);
			}
		}else {
			creditCards.put(currentUser.getSessionId(), new HashSet<>());
			creditCards.get(currentUser.getSessionId()).add(newCc);
		}
	}

}
