package a_04_event.controller;

import a_01_main.controller.action.Action;
import a_04_event.controller.action.EventsDeleteAction;
import a_04_event.controller.action.EventsListAction;
import a_04_event.controller.action.EventsUpdateAction;
import a_04_event.controller.action.EventsUpdateFormAction;
import a_04_event.controller.action.EventsViewAction;
import a_04_event.controller.action.EventsWriteAction;
import a_04_event.controller.action.EventsWriteFormAction;

public class EventActionFactory {
	private EventActionFactory() {}
	private static EventActionFactory instance = new EventActionFactory();
	public static EventActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		//이벤트 ActionFactory
		if(command.equals("events_list")) {
			action = new EventsListAction();
		}else if(command.equals("events_view")) {
			action = new EventsViewAction();
		}else if(command.equals("events_write_form")) {
			action = new EventsWriteFormAction();
		}else if(command.equals("events_write")) {
			action = new EventsWriteAction();
		}else if(command.equals("events_update_form")) {
			action = new EventsUpdateFormAction();
		}else if(command.equals("events_update")) {
			action = new EventsUpdateAction();
		}else if(command.equals("events_delete")) {
			action = new EventsDeleteAction();
		}
		
		return action;
	}
}
