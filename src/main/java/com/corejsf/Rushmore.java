package com.corejsf;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class Rushmore implements Serializable {

	private static final long serialVersionUID = 1L;

	private String outcome = null;

	private Rectangle washingtonRect = new Rectangle(70, 30, 40, 40);
	private Rectangle jeffersonRect = new Rectangle(115, 45, 40, 40);
	private Rectangle rooseveltRect = new Rectangle(135, 65, 40, 40);
	private Rectangle lincolnRect = new Rectangle(175, 62, 40, 40);

	public void handleMouseClick(ActionEvent e) {
		FacesContext context = FacesContext.getCurrentInstance();
		String clientId = e.getComponent().getClientId(context);
		Map<String, String> requestParams = context.getExternalContext()
				.getRequestParameterMap();

		int x = new Integer((String) requestParams.get(clientId + ".x"))
				.intValue();
		int y = new Integer((String) requestParams.get(clientId + ".y"))
				.intValue();

		outcome = null;

		if (washingtonRect.contains(new Point(x, y)))
			outcome = "washington";

		if (jeffersonRect.contains(new Point(x, y)))
			outcome = "jefferson";

		if (rooseveltRect.contains(new Point(x, y)))
			outcome = "roosevelt";

		if (lincolnRect.contains(new Point(x, y)))
			outcome = "lincoln";

	}
	
	public String navigate() {
		return outcome;
	}
}
