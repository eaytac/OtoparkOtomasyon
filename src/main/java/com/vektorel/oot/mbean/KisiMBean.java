package com.vektorel.oot.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.vektorel.oot.entity.Kisi;
import com.vektorel.oot.service.KisiService;

@ManagedBean(name="kisiBean")
@ViewScoped
public class KisiMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 461195612342326214L;
	
	private KisiService kisiService;
	
	private List<Kisi> kisiler;
	private Kisi kisi;
	
	@PostConstruct
	private void init(){
		kisiService = new KisiService();
		kisi = new Kisi();
		listele();
	}
	
	public void kaydet() {
		
		try {
			kisiService.save(kisi);
			kisi = new Kisi();
			listele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listele() {
		kisiler = kisiService.getAll(null);
	}
	
	public List<Kisi> getKisiler() {
		return kisiler;
	}
	
	public Kisi getKisi() {
		return kisi;
	}
	
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
}