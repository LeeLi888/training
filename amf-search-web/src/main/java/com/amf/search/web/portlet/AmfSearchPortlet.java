package com.amf.search.web.portlet;

import com.amf.search.web.constants.AmfSearchPortletKeys;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Writer;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=message"
	},
	service = Portlet.class
)
public class AmfSearchPortlet extends MVCPortlet {

	@ProcessAction(name = "sendMessage")
	public void sendMessage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String message = ParamUtil.getString(actionRequest, "message", "");
		actionResponse.getRenderParameters().setValue("message", message);
	}


}