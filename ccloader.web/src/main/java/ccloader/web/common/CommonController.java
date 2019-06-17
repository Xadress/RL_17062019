package ccloader.web.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/common")
public class CommonController {
	
	@GetMapping()
	public String idle() {
		return "CCLoader is up and running! :)";
	}

}
