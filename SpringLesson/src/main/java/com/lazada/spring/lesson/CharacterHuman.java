package com.lazada.spring.lesson;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("human")
@Scope("prototype")
public class CharacterHuman implements IPlayerType
{

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("How'se bout ya!");
	}

}
