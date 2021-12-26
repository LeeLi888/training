package com.amf.search.results.web.portlet;

import com.amf.search.results.model.Member;
import com.amf.search.results.service.MemberService;
import com.amf.search.results.web.constants.AmfSearchResultsPortletKeys;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
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
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfSearchResults",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=message"
	},
	service = Portlet.class
)
public class AmfSearchResultsPortlet extends MVCPortlet {

	@Reference
	private MemberService _memberService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String zipCode = ParamUtil.getString(renderRequest, "message", "");

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		List<Member> members = _memberService.getMembersByCompanyIdAndZipCode(companyId, zipCode, start, end);
		long memberCount = _memberService.getEventsCountByCompanyIdAndZipCode(companyId, zipCode);

		renderRequest.setAttribute("members", members);
		renderRequest.setAttribute("memberCount" , memberCount);
		renderRequest.setAttribute("zipCode", zipCode);

		super.doView(renderRequest, renderResponse);
	}

}