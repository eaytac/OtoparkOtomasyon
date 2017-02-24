package com.vektorel.oot.mbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="indexBean")
@ViewScoped
public class IndexMBean implements Serializable {

	private static final long serialVersionUID = -5202884559153356422L;

	private String mesaj = "JSF Uygulamasý";
	
	@PostConstruct
	private void init(){
		
	}
	
	public void butonaTiklandi() {
		System.out.println(mesaj + "  Butona týklandý...");
	}
	
	public String getMesaj() {
		return mesaj;
	}
	
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

}