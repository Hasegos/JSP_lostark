package com.LostArk.lostark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostarkApplication {

	public static void main(String[] args){
		SpringApplication.run(LostarkApplication.class, args);
		Test test = new Test(); // class 복사본
		System.out.println(test.name);
		test.hello();
		Friend friend = new Friend("슬픔");
		System.out.println(friend.name);
	}

}

class Test {
	String name = "kim";
	void hello(){
		System.out.println("hello");
	}
}

class Friend {
	String name = "kim";
	int age = 20;
	Friend(String name){ // 생성자 (constructor)
		this.name = name;
	}
}