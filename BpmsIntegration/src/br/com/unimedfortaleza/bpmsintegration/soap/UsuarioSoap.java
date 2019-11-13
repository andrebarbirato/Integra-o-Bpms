package br.com.unimedfortaleza.bpmsintegration.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioSoap implements Serializable{

	
	private  @JsonProperty("name") String name;
	private  @JsonProperty("emailAddress") String emailAddress;
    private  @JsonProperty("displayName") String displayName;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
