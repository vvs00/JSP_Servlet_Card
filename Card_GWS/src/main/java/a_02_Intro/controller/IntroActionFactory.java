package a_02_Intro.controller;

import a_01_main.controller.action.Action;
import a_02_Intro.controller.action.IntroPageAction;

public class IntroActionFactory {
	private IntroActionFactory() {}
	private static IntroActionFactory instance = new IntroActionFactory();
	public static IntroActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
			
		if(command.equals("intropage")) {
			action = new IntroPageAction();
		}
		
		return action;
	}
}
