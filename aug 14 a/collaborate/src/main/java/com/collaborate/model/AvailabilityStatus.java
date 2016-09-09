package com.collaborate.model;

import java.io.Serializable;

public class AvailabilityStatus implements Serializable {
private boolean availble;

/**
 * @return the availble
 */
public boolean isAvailble() {
	return availble;
}

/**
 * @param availble the availble to set
 */
public void setAvailble(boolean availble) {
	this.availble = availble;
}

public AvailabilityStatus(boolean availble) {
	super();
	this.availble = availble;
}


}
