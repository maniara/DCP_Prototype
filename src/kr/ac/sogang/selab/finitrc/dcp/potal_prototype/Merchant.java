package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Merchant {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private String userAccount;
	@Persistent
	private String name;
	@Persistent
	private String category;
	@Persistent
	private String registNumber;
	@Persistent
	private String representatives;
	@Persistent
	private String address;
	@Persistent
	private String tel;
	@Persistent
	private String logoUrl;
	@Persistent
	private double latitude;
	@Persistent
	private double longitude;
	
	public Merchant(String userAccount, String name, String category, String registNumber, String representatives, String address,
			String tel, String logoUrl, double latitude, double longitude) {
		super();
		this.userAccount = userAccount;
		this.name = name;
		this.category = category;
		this.registNumber = registNumber;
		this.representatives = representatives;
		this.address = address;
		this.tel = tel;
		this.logoUrl = logoUrl;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegistNumber() {
		return registNumber;
	}

	public void setRegistNumber(String registNumber) {
		this.registNumber = registNumber;
	}

	public String getRepresentatives() {
		return representatives;
	}

	public void setRepresentatives(String representatives) {
		this.representatives = representatives;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Long getKey() {
		return key;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	
	
	
	
	
	
}
