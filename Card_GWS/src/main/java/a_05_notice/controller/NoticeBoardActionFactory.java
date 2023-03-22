package a_05_notice.controller;


import a_01_main.controller.action.Action;
import a_05_notice.controller.action.NoticeBoardDeleteAction;
import a_05_notice.controller.action.NoticeBoardListAction;
import a_05_notice.controller.action.NoticeBoardUpdateAction;
import a_05_notice.controller.action.NoticeBoardUpdateFormAction;
import a_05_notice.controller.action.NoticeBoardViewAction;
import a_05_notice.controller.action.NoticeBoardWriteFormAction;
import a_05_notice.controller.action.NoticeBoardwriteAction;

public class NoticeBoardActionFactory {
	private NoticeBoardActionFactory() {}
	private static NoticeBoardActionFactory instance = new NoticeBoardActionFactory();
	public static NoticeBoardActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("noticeBoardList")) {
			action = new NoticeBoardListAction();
		}else if(command.equals("noticeBoardWriteForm")) {
			action = new NoticeBoardWriteFormAction();
		}else if(command.equals("NoticeBoardwrite")) {
			action = new NoticeBoardwriteAction();
		}else if(command.equals("noticeBoardView")) {
			action = new NoticeBoardViewAction();
		}else if(command.equals("NoticeBoardUpdateForm")) {
			action = new NoticeBoardUpdateFormAction();
		}else if(command.equals("noticeBoardUpdate")) {
			action = new NoticeBoardUpdateAction();
		}else if(command.equals("NoticeBoardDelete")) {
			action = new NoticeBoardDeleteAction();
		}
		
		return action;
	}
}
