package edu.foothill.controller.gui;

import java.util.EventListener;
/**
 * Custom interface in order to make a listener that returns a object of Media
 * instead of simply identifying the button of origin.
 * @author davidgudeman
 *
 */

public interface ViewListener extends EventListener {

	void viewEventOccured(ViewEvent event);

}
