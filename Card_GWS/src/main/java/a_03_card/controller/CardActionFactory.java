package a_03_card.controller;

import a_01_main.controller.action.Action;
import a_03_card.controller.action.CardDeleteAction;
import a_03_card.controller.action.CardListAction;
import a_03_card.controller.action.CardUpdateAction;
import a_03_card.controller.action.CardUpdateformAciton;
import a_03_card.controller.action.CardViewAction;
import a_03_card.controller.action.CardWriteAction;
import a_03_card.controller.action.CardWriteFormAction;

public class CardActionFactory {
	private CardActionFactory() {}
	private static CardActionFactory instance = new CardActionFactory();
	public static CardActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		//카드 ActionFactory
		if(command.equals("card_list")) {
			action = new CardListAction();
		}else if(command.equals("card_view")) {
			action = new CardViewAction();
		}else if(command.equals("card_write")) {
			action = new CardWriteAction();
		}else if(command.equals("card_write_form")) {
			action = new CardWriteFormAction();
		}else if(command.equals("card_update")) {
			action = new CardUpdateAction();
		}else if(command.equals("card_update_form")) {
			action = new CardUpdateformAciton();
		}else if(command.equals("card_delete")) {
			action = new CardDeleteAction();
		} 
		
		return action;
	}
}
