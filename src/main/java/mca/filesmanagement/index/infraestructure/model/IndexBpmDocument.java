package mca.filesmanagement.index.infraestructure.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "index_bpm")
public class IndexBpmDocument {
	
	@Id
	private String id;
	private Date date;
	private String phaseCode;
	private String phaseName;
	
	public IndexBpmDocument() {
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
}
