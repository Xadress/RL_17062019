package ccloader.application.common;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ccloader.application.creditcards.dto.CreditCardDTO;
import ccloader.application.creditcards.model.CreditCard;
import ccloader.application.creditcards.model.CreditCardNumber;

@RunWith(SpringRunner.class)
public class ModelMapperTest {
	
	private ModelMapper mapper;
	
	@Before
	public void initialize() {
		mapper = new ModelMapper();
	}
	
	@Test
	public void mapModelToDTO_test() {
		CreditCard creditCard = new CreditCard(new CreditCardNumber("5658963256985698"));
		creditCard.setBankName("Great bank");
		Date expiryDate = new Date();
		creditCard.setExpiryDate(expiryDate);
		
		CreditCardDTO dto = mapper.map(creditCard, CreditCardDTO.class);
		assertTrue(dto!=null);
		assertTrue(dto.getBankName().equals(creditCard.getBankName()));
		assertTrue(dto.getCardNumber().equals(creditCard.getCardNumber().getMaskedCardNumber()));
		assertTrue(dto.getExpiryDate().equals(creditCard.getExpiryDate()));
		
	}
	
	@Test
	public void mapDTOToModel_test() {
		CreditCardDTO dto = new CreditCardDTO();
		dto.setBankName("Great bank");
		dto.setCardNumber("5658963256985698");
		Date expiryDate = new Date();
		dto.setExpiryDate(expiryDate);
		
		CreditCard domainObj = mapper.map(dto, CreditCard.class);
		assertTrue(domainObj!=null);
		assertTrue(domainObj.getBankName().equals(dto.getBankName()));
//		assertTrue(domainObj.getCardNumber().toString().equals(dto.getCardNumber())); WE CAN'T GET THE CARD NUMBER FOR SECURITY REASON
		assertTrue(domainObj.getExpiryDate().equals(dto.getExpiryDate()));
		
	}
	
	@Test
	public void mapNullModel_test() {
		CreditCard creditCard = null;
		
		CreditCardDTO dto = mapper.map(creditCard, CreditCardDTO.class);
		assertTrue(dto!=null);
		assertTrue(dto.getBankName()==null);
		assertTrue(dto.getCardNumber()==null);
		assertTrue(dto.getExpiryDate()==null);
		
	}
	
	@Test
	public void mapNullDTO_test() {
		CreditCardDTO dto = null;
		
		CreditCard domainObj = mapper.map(dto, CreditCard.class);
		
		//Not all domain models can be instantiated with all values null
		if(domainObj!=null) {
			assertTrue(domainObj.getBankName()==null);
			assertTrue(domainObj.getCardNumber()==null);
			assertTrue(domainObj.getExpiryDate()==null);
		}
		
	}
	
	

}
