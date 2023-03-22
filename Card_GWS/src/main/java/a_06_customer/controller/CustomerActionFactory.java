package a_06_customer.controller;

import a_01_main.controller.action.Action;
import a_06_customer.controller.action.CustomerBoardBlindAction;
import a_06_customer.controller.action.CustomerBoardDeleteAction;
import a_06_customer.controller.action.CustomerBoardListAction;
import a_06_customer.controller.action.CustomerBoardReplyFormAction;
import a_06_customer.controller.action.CustomerBoardReplywriteAction;
import a_06_customer.controller.action.CustomerBoardUpdateAction;
import a_06_customer.controller.action.CustomerBoardUpdateFormAction;
import a_06_customer.controller.action.CustomerBoardWriteFormAction;
import a_06_customer.controller.action.CustomerBoardwriteAction;
import a_06_customer.controller.action.CutomerBoardViewAction;
import a_06_customer.controller.action.CustomerBoardBlindReleaseAction;

public class CustomerActionFactory {
	private CustomerActionFactory() {}
	private static CustomerActionFactory instance = new CustomerActionFactory();
	public static CustomerActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("CustomerBoardList")) {
			action = new CustomerBoardListAction();
		}else if(command.equals("cutomerBoardView")){
			action = new CutomerBoardViewAction();
		}else if(command.equals("CustomerBoardWriteForm")) {
			action = new CustomerBoardWriteFormAction();
		}else if(command.equals("CustomerBoardwrite")) {
			action = new CustomerBoardwriteAction();
		}else if(command.equals("CustomerBoardDelete")) {
			action = new CustomerBoardDeleteAction();
		}else if(command.equals("CustomerBoardUpdateForm")) {
			action = new CustomerBoardUpdateFormAction();
		}else if(command.equals("CustomerBoardUpdate")) {
			action = new CustomerBoardUpdateAction();
		}else if(command.equals("CustomerBoardReplyForm")) {
			action = new CustomerBoardReplyFormAction();
		}else if(command.equals("CustomerBoardReplywrite")) {
			action = new CustomerBoardReplywriteAction();
		}else if(command.equals("CustomerBoardBlind")) {
			action = new CustomerBoardBlindAction();
		}else if(command.equals("blindRelease")) {
			action = new CustomerBoardBlindReleaseAction();
		}
		
		return action;
	}
}
