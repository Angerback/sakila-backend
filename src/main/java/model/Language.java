package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT a FROM Language a")
public class Language implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Language(){
		
		
	}
	
	@Id
	@Column(name="language_id", unique=true, nullable=false)
	private int languageId;

	@Column(name="name", nullable=false, length=20)
	private String name;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
