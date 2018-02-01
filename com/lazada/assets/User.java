package com.lazada.assets;

public class User 
{
	private String name;
	private String email;
	private Account account;
	
	public User(String name, String email, Account account) {
		super();
		this.name = name;
		this.email = email;
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Account getAccount() {
		return account;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
