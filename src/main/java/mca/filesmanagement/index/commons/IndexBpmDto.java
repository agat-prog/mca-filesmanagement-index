package mca.filesmanagement.index.commons;

import java.util.Date;

public class IndexBpmDto {
	
	private String id;
	private String phaseCode;
	private String phaseName;
	private Date date;

	public IndexBpmDto() {
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
}
