package com.amf.event.monitor.web.portlet;

import com.amf.event.monitor.web.constants.AmfEventMonitorPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfEventMonitor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfEventMonitorPortletKeys.AMFEVENTMONITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.instanceable=false",
	},
	service = Portlet.class
)
public class AmfEventMonitorPortlet extends MVCPortlet {

	public void all(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String type =  ParamUtil.getString(actionRequest, "type");
		System.out.println("First Method==>"+type);

		//After submit First Tab is selected
		actionRequest.setAttribute("selectedTab", "First Tab");
	}

}