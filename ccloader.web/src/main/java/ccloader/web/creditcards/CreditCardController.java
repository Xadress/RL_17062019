package ccloader.web.creditcards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ccloader.application.common.PagedList;
import ccloader.application.creditcards.dto.CreditCardDTO;
import ccloader.application.creditcards.service.interf.ICreditCardService;
import ccloader.application.creditcards.service.responses.InsertUpdateCreditCardResponseDTO;

@RestController
@RequestMapping("api/credit-card")
public class CreditCardController {
	
	@Autowired
	private ICreditCardService creditCardService;
	
	@GetMapping("/list")
	public PagedList<CreditCardDTO> getCreditCardsPaged(@RequestParam(required = false)Integer page){
		if(page==null) {
			page = 1;
		}
		
		return creditCardService.getCreditCardsPaged(page);
	}
	
	@PostMapping("/insert-update")
	public InsertUpdateCreditCardResponseDTO insertUpdateCreditCards(@RequestBody List<CreditCardDTO> ccList){
		return creditCardService.insertUpdateCreditCards(ccList);
	}

}
