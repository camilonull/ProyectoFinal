package controllers;

import views.principal.JFramePrincipal;

public class CentralController {
	
	private JFramePrincipal jFramePrincipal;
	
	public CentralController() {
		init();
	}
	private void init() {
		JFramePrincipal jFrameMain = new JFramePrincipal();
		this.jFramePrincipal = jFrameMain;
        jFrameMain.setVisible(true);
	}

	public JFramePrincipal getjFramePrincipal() {
		return jFramePrincipal;
	}

	public void setjFramePrincipal(JFramePrincipal jFramePrincipal) {
		this.jFramePrincipal = jFramePrincipal;
	}
}
