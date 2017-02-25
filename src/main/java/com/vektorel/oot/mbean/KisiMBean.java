package com.vektorel.oot.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.vektorel.oot.entity.Kisi;
import com.vektorel.oot.service.KisiService;

@ManagedBean(name="kisiBean")
@ViewScoped
public class KisiMBean implements Serializable {

	/**	
	 * 
	 */
	private static final long serialVersionUID = 461195612342326214L;
	
	private transient KisiService kisiService;
	
	private List<Kisi> kisiler;
	private Kisi kisi;
	
	@PostConstruct
	private void init(){
		kisiService = new KisiService();
		yeni();
		listele();
	}
	
	public void kaydet() {
		
		try {
			if (kisi.getId() == null){
				kisiService.save(kisi);
				mesajGoster("Kayıt", "Kayıt Eklendi");
			} else {
				kisiService.update(kisi);
				mesajGoster("Kayıt", "Kayıt Güncellendi");
			}
			yeni();
			listele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void seciliKayit(Long id) {
		this.kisi = kisiService.getById(id);
	}

	public void seciliyiSil(Long id) {
		kisiService.delete(id);
		mesajGoster("Kayıt Silindi", "Kayıt No :" + id);
		listele();
	}
	
	public void yeni() {
		kisi = new Kisi();
	}
	
	public void mesajGoster(String baslik, String detay) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(baslik, detay) );
    }
	
	public void listele() {
		kisiler = kisiService.getAll(null);
		mesajGoster("Kayıtlar Listelendi", "Kayıt Sayısı :" + kisiler.size());
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