package com.amf.newsletter.web.portlet.actions;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.service.NewsletterLocalService;
import com.amf.newsletter.web.constants.AmfNewsletterPortletKeys;
import com.amf.newsletter.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.util.ArrayList;
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
            "mvc.command.name=" + MVCCommandNames.NEWLETTER_SEARCH
    },
    service = MVCRenderCommand.class
)
public class NewletterSearchMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private NewsletterLocalService newsletterLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) throws PortletException {
        String keyword = ParamUtil.getString(request, "keyword","");

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

//        PortalUtil.copyRequestParameters(actionRequest, actionResponse);

        return "/newsletter/search.jsp";
    }


}