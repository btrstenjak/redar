package hr.hrcity.eredar.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.hrcity.eredar.model.Grad;
import hr.hrcity.eredar.service.GradService;




@RestController
@RequestMapping("grad")
public class GradController {

	@Autowired
	private GradService entityService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<Iterable<Grad>> getAllEntities(HttpSession request) {
			Iterable<Grad> rez2 = this.entityService.getAllEntity();
			return ResponseEntity.ok().body(rez2);
	}
	
	
	
}
