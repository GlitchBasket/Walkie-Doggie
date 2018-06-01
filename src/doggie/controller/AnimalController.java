package doggie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import doggie.animals.dao.AnimalRepository;
import doggie.animals.dao.CompatibilityRepository;
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
}
