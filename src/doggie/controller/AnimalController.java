package doggie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import doggie.animals.dao.ACRepository;
import doggie.animals.dao.AnimalRepository;
import doggie.animals.dao.CompatibilityRepository;
import doggie.animals.dao.ImpfungRepository;
import doggie.animals.model.AnimalModel;
import doggie.animals.model.Impfung;
import doggie.animals.model.TierArt;
import doggie.animals.model.TierVertr�glichkeit;
import doggie.animals.model.Vertr�glichkeit;

@Controller
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	CompatibilityRepository compatibilityRepository;
	
	@Autowired
	ImpfungRepository impfungRepository;
	
	@Autowired
	ACRepository acRepository;
	
	@RequestMapping(value = { "/fill" })
	public String fillData(Model model) {
		
		TierArt art1 = new TierArt("Hund");
		Impfung impfung1 = new Impfung("cool");
		Impfung impfung2 = new Impfung("cool2");
		Vertr�glichkeit vt1 = new Vertr�glichkeit("vt1");
		Vertr�glichkeit vt2 = new Vertr�glichkeit("vt2");
		
		AnimalModel test = new AnimalModel("a", "b", "c", 12, "a", false, "asdasdas");
		test.addImpfung(impfung1);
		test.addImpfung(impfung2);
		test.setTierArt(art1);
		
		TierVertr�glichkeit tttt = new TierVertr�glichkeit();
		tttt.setTier(test);
		tttt.setVertr�glichkeit(vt1);
		tttt.setStatus(true);
		
		compatibilityRepository.save(tttt);
					
		return "index";
	}
	
	@RequestMapping(value = "/petbook")
	public String petbook(Model model) {
		
		List<AnimalModel> animals = animalRepository.findAll();

		model.addAttribute("animals", animals);
		
		return "petbook";
	}
	
	@RequestMapping(value = { "/profil" })
	public String profil(Model model, @RequestParam int id) {
		AnimalModel animal = animalRepository.findById(id);
		model.addAttribute("animal", animal);
		List<Impfung> impfungen = impfungRepository.findAllByAnimals(animal);
		model.addAttribute("impfungen", impfungen);
		List<TierVertr�glichkeit> acs = acRepository.findAllByTier(animal);
		model.addAttribute("acs", acs);
		
		return "profil";
	}
}
