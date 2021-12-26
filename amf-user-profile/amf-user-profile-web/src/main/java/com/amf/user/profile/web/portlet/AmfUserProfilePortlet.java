package com.amf.user.profile.web.portlet;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.GeneralProfileLocalServiceUtil;
import com.amf.user.profile.service.MovieInterestServiceUtil;
import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;

import com.amf.user.profile.web.constants.MVCCommandNames;
import com.amf.user.profile.web.model.UserProfile;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfUserProfile",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfUserProfilePortletKeys.AMFUSERPROFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.instanceable=false",
	},
	service = Portlet.class
)
public class AmfUserProfilePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

//	@ProcessAction(name = "dispatch")
//	public void dispatch(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
//
//		String screenName = ParamUtil.getString(actionRequest, "screenName", "");
//
//		MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
//		renderParameters.setValue("mvcRenderCommandName", MVCCommandNames.PROFILE_VIEW);
//		renderParameters.setValue("screenName", screenName);
//	}

}