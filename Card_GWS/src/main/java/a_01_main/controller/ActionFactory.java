package a_01_main.controller;

import a_01_main.controller.action.Action;
import a_01_main.controller.action.MainPageAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		if(command==(null)) {
			action = new MainPageAction();
		}
		
		return action;
	}
}
