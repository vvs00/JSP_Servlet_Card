package a_07_wishlist.controller;

import a_01_main.controller.action.Action;
import a_07_wishlist.controller.action.MyPageAction;
import a_07_wishlist.controller.action.WishlistAction;
import a_07_wishlist.controller.action.WishlistAddAction;
import a_07_wishlist.controller.action.WishlistDeleteAction;

public class WishlistActionFactory {
	private WishlistActionFactory() {
	}

	private static WishlistActionFactory instance = new WishlistActionFactory();

	public static WishlistActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("wishlist")) {
			action = new WishlistAction();
		} else if (command.equals("wishlistAdd")) {
			action = new WishlistAddAction();
		} else if (command.equals("wishlistDelete")) {
			action = new WishlistDeleteAction();
		} else if(command.equals("myPageAction")) {
			action = new MyPageAction();
		}

		return action;
	}
}
