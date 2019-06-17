package ccloader.application.creditcards.service.interf;

import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.user.model.User;

public interface ICreditCardCommandRepository {

	void insertUpdateCreditCard(CreditCard cc, User currentUser);

}
