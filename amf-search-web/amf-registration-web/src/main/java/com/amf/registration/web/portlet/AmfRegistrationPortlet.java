package com.amf.registration.web.portlet;

import com.amf.registration.model.UserExternal;
import com.amf.registration.web.constants.AmfRegistrationPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.RegionLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfRegistration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfRegistrationPortletKeys.AMFREGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.instanceable=false",
	},
	service = Portlet.class
)
public class AmfRegistrationPortlet extends MVCPortlet {

	@Reference
	protected CountryLocalService countryLocalService;

	@Reference
	protected RegionLocalService regionLocalService;

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

			String a3 = "USA";
			long companyId = serviceContext.getCompanyId();

			Country country = countryLocalService.getCountryByA3(companyId, a3);

			List<Region> regions = regionLocalService.getRegions(country.getCountryId(), true);

			renderRequest.setAttribute("regions", regions);

		} catch (PortalException e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}
}