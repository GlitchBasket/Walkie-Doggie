package doggie.animals.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tier_vertraeglichkeit")
public class TierVertr�glichkeit implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	//Relationship
	
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "tier_id")
	private AnimalModel tier;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "vertr�glichkeit_id")
	private Vertr�glichkeit vertr�glichkeit;
    
    @Column
	private boolean status;
    
    
    
	//Constructor
    
    public TierVertr�glichkeit() {
	}
      
	public TierVertr�glichkeit(AnimalModel tier, Vertr�glichkeit vertr�glichkeit, boolean status) {
		super();
		this.tier = tier;
		this.vertr�glichkeit = vertr�glichkeit;
		this.status = status;
	}

	@Version
	long version;
    
	

	//Getter + Setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AnimalModel getTier() {
		return tier;
	}
	
	public void setTier(AnimalModel tier) {
		this.tier = tier;
	}
	
	public Vertr�glichkeit getVertr�glichkeit() {
		return vertr�glichkeit;
	}
	
	public void setVertr�glichkeit(Vertr�glichkeit vertr�glichkeit) {
		this.vertr�glichkeit = vertr�glichkeit;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
