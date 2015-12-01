package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Wallet {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private String walletNic;
	
	@Persistent
	private String userAccount;
	@Persistent
	private String publicKey;
	@Persistent
	private String privateKey;
	
	public Wallet(String userAccount, String walletNic, String publicKey, String privateKey) {
		super();
		this.userAccount = userAccount;
		this.walletNic = walletNic;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public Long getKey() {
		return key;
	}
	
	
}
