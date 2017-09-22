package online.smartcompute.kafkamanagementui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopicData {
	public String name;
	public int noOfPartitions;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the noOfPartitions
	 */
	public int getNoOfPartitions() {
		return noOfPartitions;
	}

	/**
	 * @param noOfPartitions
	 *            the noOfPartitions to set
	 */
	public void setNoOfPartitions(int noOfPartitions) {
		this.noOfPartitions = noOfPartitions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopicData [name=" + name + ", noOfPartitions=" + noOfPartitions + "]";
	}
}
