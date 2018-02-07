package com.lazada.spring.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PlayerCharacter {
	
	@Autowired
	@Qualifier("human")
	IPlayerType playerMajor;
	
	@Autowired
	@Qualifier("human")
	IPlayerType playerMinor;
	
	public PlayerCharacter(IPlayerType playertype)
	{
		this.playerMajor = playertype;
	}
	
	//@Autowired
	//@Qualifier("orc")
	public void setPlayer(IPlayerType ptype,Object obj)
	{
		this.playerMajor = ptype;
	}
	
	public void speak()
	{
		this.playerMajor.talk();
	}
}
