package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Product {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private Long merchantKey;
	
	@Persistent
	private String productName;
	
	@Persistent
	private Double dcPrice;
	
	@Persistent
	private int wonPrice;
	
	@Persistent
	private String merchantWalletAddress;
	
	@Persistent
	private String picUrl1;
	
	@Persistent
	private String picUrl2;

	public Product(Long merchantKey, String productName, Double dcPrice, int wonPrice, String merchantWalletAddress,
			String picUrl1, String picUrl2) {
		super();
		this.merchantKey = merchantKey;
		this.productName = productName;
		this.dcPrice = dcPrice;
		this.wonPrice = wonPrice;
		this.merchantWalletAddress = merchantWalletAddress;
		this.picUrl1 = picUrl1;
		this.picUrl2 = picUrl2;
	}

	public Long getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(Long merchantKey) {
		this.merchantKey = merchantKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getDcPrice() {
		return dcPrice;
	}

	public void setDcPrice(Double dcPrice) {
		this.dcPrice = dcPrice;
	}

	public int getWonPrice() {
		return wonPrice;
	}

	public void setWonPrice(int wonPrice) {
		this.wonPrice = wonPrice;
	}

	public String getMerchantWalletAddress() {
		return merchantWalletAddress;
	}

	public void setMerchantWalletAddress(String merchantWalletAddress) {
		this.merchantWalletAddress = merchantWalletAddress;
	}

	public String getPicUrl1() {
		return picUrl1;
	}

	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}

	public String getPicUrl2() {
		return picUrl2;
	}

	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}

	public Long getKey() {
		return key;
	}
	
	
	
	
	
}
