package ccloader.application.creditcards.service.interf;

import java.util.List;

import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.user.model.User;

public interface ICreditCardQueryRepository {

	List<CreditCard> getCreditCardsByUser(User user);

}
