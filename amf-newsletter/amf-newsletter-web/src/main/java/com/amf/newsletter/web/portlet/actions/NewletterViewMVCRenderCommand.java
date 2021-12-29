package com.amf.newsletter.web.portlet.actions;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.service.ArticleLocalService;
import com.amf.newsletter.service.NewsletterLocalService;
import com.amf.newsletter.web.constants.AmfNewsletterPortletKeys;
import com.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author liferay
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
        "mvc.command.name=" + MVCCommandNames.NEWLETTER_VIEW
    },
    service = MVCRenderCommand.class
)
public class NewletterViewMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private NewsletterLocalService newsletterLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private ArticleLocalService articleLocalService;

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

        int issueNumber = ParamUtil.getInteger(renderRequest, "issueNumber");

//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        long companyId = themeDisplay.getCompanyId();
//        long groupId = themeDisplay.getScopeGroupId();

        try {

            Newsletter newsletter = newsletterLocalService.getNewsletter(issueNumber);
            //get byline
            String strByline = newsletter.getByline();
            if (strByline != null && !"".equals(strByline)) {
                StringBuilder bylines = new StringBuilder();
                for (String bylineId : strByline.split(",")) {
                    bylines.append("," + userLocalService.getUser(Long.parseLong(bylineId)).getFullName());
                }
                renderRequest.setAttribute("byline", bylines.toString().substring(1));
            }

            renderRequest.setAttribute("newsletter", newsletter);
            renderRequest.setAttribute("articles", articleLocalService.getArticlesByIssueNumber(issueNumber));

        } catch (PortalException e) {
           throw new PortletException(e);
        }

        return "/newsletter/view.jsp";
    }


}