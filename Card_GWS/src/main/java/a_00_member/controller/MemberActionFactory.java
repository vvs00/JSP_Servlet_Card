package a_00_member.controller;

import a_00_member.controller.action.DeleteAction;
import a_00_member.controller.action.DeleteFormAction;
import a_00_member.controller.action.LoginAction;
import a_00_member.controller.action.LoginFormAction;
import a_00_member.controller.action.LogoutAction;
import a_00_member.controller.action.ModifyAction;
import a_00_member.controller.action.ModifyFormAction;
import a_00_member.controller.action.SignUpAction;
import a_00_member.controller.action.SignUpFormAction;
import a_00_member.controller.action.TermsAction;
import a_01_main.controller.action.Action;

public class MemberActionFactory {
	private MemberActionFactory() {}
	private static MemberActionFactory instance = new MemberActionFactory();
	public static MemberActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
	
		if(command.equals("signupform")) {
			action = new SignUpFormAction();
		}else if(command.equals("signup")) {
			action = new SignUpAction();
		}else if(command.equals("terms")) {
			action = new TermsAction();
		}else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("loginform")) {
			action = new LoginFormAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}else if(command.equals("modify")) {
			action = new ModifyAction();
		}else if(command.equals("modifyform")) {
			action = new ModifyFormAction();
		}else if(command.equals("deleteform")) {
			action = new DeleteFormAction();
		}else if(command.equals("delete")) {
			action = new DeleteAction();
		}
		return action;
	}
}