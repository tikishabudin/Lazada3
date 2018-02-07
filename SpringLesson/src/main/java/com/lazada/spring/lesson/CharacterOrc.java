package com.lazada.spring.lesson;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("orc")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CharacterOrc implements IPlayerType {

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("WAAAAAARRRGGGHHHHHHH!");
	}

}
