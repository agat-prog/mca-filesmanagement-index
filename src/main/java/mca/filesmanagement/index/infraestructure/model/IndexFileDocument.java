package mca.filesmanagement.index.infraestructure.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "index_file")
public class IndexFileDocument {
	
	@Id
	private String id;
	private String description;
	private String procesCode;
	private Date procesDate;
	private String phaseCode;
	private String phaseName;
	private String initOption;
	
	public IndexFileDocument() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the procesCode
	 */
	public String getProcesCode() {
		return procesCode;
	}

	/**
	 * @param procesCode the procesCode to set
	 */
	public void setProcesCode(String procesCode) {
		this.procesCode = procesCode;
	}

	/**
	 * @return the procesDate
	 */
	public Date getProcesDate() {
		return procesDate;
	}

	/**
	 * @param procesDate the procesDate to set
	 */
	public void setProcesDate(Date procesDate) {
		this.procesDate = procesDate;
	}

	/**
	 * @return the phaseCode
	 */
	public String getPhaseCode() {
		return phaseCode;
	}

	/**
	 * @param phaseCode the phaseCode to set
	 */
	public void setPhaseCode(String phaseCode) {
		this.phaseCode = phaseCode;
	}

	/**
	 * @return the phaseName
	 */
	public String getPhaseName() {
		return phaseName;
	}

	/**
	 * @param phaseName the phaseName to set
	 */
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	/**
	 * @return the initOption
	 */
	public String getInitOption() {
		return initOption;
	}

	/**
	 * @param initOption the initOption to set
	 */
	public void setInitOption(String initOption) {
		this.initOption = initOption;
	}
	
}
