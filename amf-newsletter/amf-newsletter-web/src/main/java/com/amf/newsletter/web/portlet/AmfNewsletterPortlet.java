package com.amf.newsletter.web.portlet;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.service.ArticleLocalService;
import com.amf.newsletter.service.NewsletterLocalService;
import com.amf.newsletter.service.NewsletterService;
import com.amf.newsletter.web.constants.AmfNewsletterPortletKeys;

import com.amf.newsletter.web.data.NewsletterGroup;
import com.amf.newsletter.web.data.NewsletterMonth;
import com.amf.newsletter.web.data.NewsletterYear;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author lee
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfNewsletter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=category.amf.training",
		"com.liferay.portlet.instanceable=false",
	},
	service = Portlet.class
)
public class AmfNewsletterPortlet extends MVCPortlet {

	@Reference
	private NewsletterLocalService newsletterLocalService;

	@Reference
	private ArticleLocalService articleLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<String> years = new ArrayList<>();
		List<NewsletterMonth> list = new ArrayList<>();

		Calendar calStart = Calendar.getInstance();
		calStart.add(Calendar.YEAR, -4);
		calStart.set(Calendar.MONTH, 0);

		Calendar calEnd = Calendar.getInstance();

		for (int i=calStart.get(Calendar.YEAR); i<=calEnd.get(Calendar.YEAR); i++) {
			years.add(String.valueOf(i));
		}

		String curTab = ParamUtil.getString(renderRequest, "curTab");
		if (curTab == null || "".equals(curTab.trim())) {
			curTab = String.valueOf(calEnd.get(Calendar.YEAR));
		}
		int year = Integer.parseInt(curTab);

		// month loop
		for (int month=0; month<12; month++) {
			NewsletterMonth newsletterMonth = new NewsletterMonth(year, month);

			List<NewsletterGroup> newsletterGroups = new ArrayList<>();

			List<Newsletter> newsletters = newsletterLocalService.getNewslettersByYearmonth(year, month);
			newsletters.stream().forEach(el->{
				NewsletterGroup group = new NewsletterGroup();
				group.setNewsletter(el);
				group.setArticles(articleLocalService.getArticlesByIssueNumber(el.getIssueNumber()));
				newsletterGroups.add(group);
			});

			if (newsletterGroups.size() > 0) {
				newsletterMonth.setNewsletterGroups(newsletterGroups);
				list.add(newsletterMonth);
			}
		}

		renderRequest.setAttribute("years", years.toArray(new String[years.size()]));
		renderRequest.setAttribute("list", list);
		renderRequest.setAttribute("curTab", curTab);

		super.render(renderRequest, renderResponse);
	}
}