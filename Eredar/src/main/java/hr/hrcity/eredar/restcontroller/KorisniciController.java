package hr.hrcity.eredar.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.hrcity.eredar.model.Korisnici;
import hr.hrcity.eredar.service.KorisniciService;

@RestController
@RequestMapping("korisnici")
public class KorisniciController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private KorisniciService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Korisnici>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Korisnici> getEntityById(@PathVariable long id) {
		Korisnici korisnici = this.entityService.getEntityById(id);
		if (korisnici != null) {
			if (korisnici.getId_korisnik() == 0) {
				
				this.entityService.updateEntity(korisnici);
			}
		}

		return ResponseEntity.ok().body(korisnici);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Korisnici entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Korisnici entityData) {
			try {
				
				this.entityService.updateEntity(entityData);
				return ResponseEntity.ok().body("Ispravan upis podatka");
			} catch (Exception err) {
				return ResponseEntity.status(602).body("Pogreška prilikom upisa podataka");
			}
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEntity(@PathVariable long id) {
		this.entityService.deleteEntity(id);
		return HttpStatus.OK;
	}

	@PostMapping("/test")
	public ResponseEntity<String> createEntityTest(HttpSession request) {

		Korisnici entityData = new Korisnici();
		
		entityData.setId_korisnik(1342);
		entityData.setEmail("1@2.com");


		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}
