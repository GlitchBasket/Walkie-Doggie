package doggie.animals.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "vertraeglichkeit")
public class Vertr�glichkeit implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 30)
	private String beschreibung;
	
	
	
	//Relationship
	
	@OneToMany(mappedBy="vertr�glichkeit", fetch = FetchType.LAZY)
	private Set<TierVertr�glichkeit> tiervertr�glichkeit;
	
	@Version
	long version;
	
	
	
	//Constructor
	
	public Vertr�glichkeit() {
	}

	public Vertr�glichkeit(String beschreibung) {
		super();
		this.beschreibung = beschreibung;
	}
	
	
	
	//Getter + Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<TierVertr�glichkeit> getTiere() {
		return tiervertr�glichkeit;
	}

	public void setTiere(Set<TierVertr�glichkeit> tiervertr�glichkeit) {
		this.tiervertr�glichkeit = tiervertr�glichkeit;
	}
}
