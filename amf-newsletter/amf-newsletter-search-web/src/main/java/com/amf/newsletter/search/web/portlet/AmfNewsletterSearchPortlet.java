package com.amf.newsletter.search.web.portlet;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.search.web.constants.AmfNewsletterSearchPortletKeys;

import com.amf.newsletter.service.NewsletterLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayRenderRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfNewsletterSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfNewsletterSearchPortletKeys.AMFNEWSLETTERSEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.instanceable=false",
	},
	service = Portlet.class
)
public class AmfNewsletterSearchPortlet extends MVCPortlet {

	@Reference
	private NewsletterLocalService newsletterLocalService;

	private final String PORTLET_KEY_AMF_NEWSLETTER = "_com_amf_newsletter_web_AmfNewsletterPortlet";

	@Override
	public void render(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException {
		String keyword = _getKeywordFromNewsletterPortlet(request, "keyword");

		if (keyword == null || "".equals(keyword)) {
			keyword = ParamUtil.getString(request, "keyword", "");
		}

		int currentPage = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, 5);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		try {
			SearchContext searchContext = SearchContextFactory.getInstance(
					PortalUtil.getHttpServletRequest(request));
			searchContext.setGroupIds(null); //<- important
			searchContext.setKeywords(keyword);
			searchContext.setAttribute("paginationType", "more");
			searchContext.setStart(start);
			searchContext.setEnd(end);

			Indexer<Newsletter> indexer = IndexerRegistryUtil.getIndexer(Newsletter.class);
			Hits hits = indexer.search(searchContext);
			long count = indexer.searchCount(searchContext);

			List<Newsletter> list = new ArrayList<Newsletter>();
			for (int i = 0; i < hits.getDocs().length; i++) {
				Document doc = hits.doc(i);
				long issueNumber = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

				list.add(newsletterLocalService.getNewsletter(issueNumber));
			}

			request.setAttribute("entries", list);
			request.setAttribute("count", count);

		} catch (SearchException e) {
			throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
		request.setAttribute("keyword", keyword);

		super.render(request, renderResponse);
	}

	private String _getKeywordFromNewsletterPortlet(RenderRequest renderRequest, String keyword) {
		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(renderRequest);
		HttpServletRequest httpServletRequest = liferayPortletRequest.getOriginalHttpServletRequest();
		String s = httpServletRequest.getParameter(PORTLET_KEY_AMF_NEWSLETTER + "_" + keyword);
		return s;
	}

}