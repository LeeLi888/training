package com.amf.event.monitor.web.portlet.action;

import com.amf.event.monitor.service.EventService;
import com.amf.event.monitor.web.constants.AmfEventMonitorPortletKeys;
import com.amf.event.monitor.model.Event;
import com.amf.event.monitor.web.constants.EventType;
import com.amf.event.monitor.web.constants.MVCCommandNames;
import com.amf.event.monitor.web.constants.PermissionKey;
import com.amf.event.monitor.web.internal.security.permission.resource.EventTopLevelPermission;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
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
            "javax.portlet.name=" + AmfEventMonitorPortletKeys.AMFEVENTMONITOR,
            "mvc.command.name=/",
            "mvc.command.name=" + MVCCommandNames.VIEW_EVENTS
    },
    service = MVCRenderCommand.class
)
public class ViewEventsMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private EventService _eventService;

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long companyId = themeDisplay.getCompanyId();
        long userId = themeDisplay.getUserId();
        long groupId = themeDisplay.getScopeGroupId();
        PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
        boolean isViewAll = EventTopLevelPermission.contains(
                permissionChecker, groupId, PermissionKey.VIEW_ALL);

        String curTab = ParamUtil.getString(renderRequest, "curTab");
        if (curTab == null || "".equals(curTab.trim())) {
            curTab = EventType.All;
        }

        _addEventListAttributes(renderRequest, curTab, isViewAll, companyId, userId);

        System.out.println("curTab=" + curTab);
        renderRequest.setAttribute("curTab", curTab);

        return "/view.jsp";
    }

    private void _addEventListAttributes(
            RenderRequest renderRequest, String eventType, boolean isViewAll,
            long companyId, long userId) {

        // Resolve start and end for the search.
        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);

        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;

        List<Event> events = null;
        long eventCount = 0;

        // Call the service to get the list of assignments.
        if (EventType.All.equals(eventType)) {
            if (isViewAll) {
                events = _eventService.getEventsByCompanyId(companyId, start, end);
                eventCount = _eventService.getEventsCountByCompanyId(companyId);
            } else {
                events = _eventService.getEventsByCompanyIdAndUserId(companyId, userId, start, end);
                eventCount = _eventService.getEventsCountByCompanyIdAndUserId(companyId, userId);
            }
        } else {
            if (isViewAll) {
                events = _eventService.getEventsByCompanyIdAndEventType(companyId, eventType, start, end);
                eventCount = _eventService.getEventsCountByCompanyIdAndEventType(companyId, eventType);
            } else {
                events = _eventService.getEventsByCompanyIdAndUserIdAndEventType(companyId, userId, eventType, start, end);
                eventCount = _eventService.getEventsCountByCompanyIdAndUserIdAndEventType(companyId, userId, eventType);
            }
        }

        // Set request attributes.
        renderRequest.setAttribute("events", events);
        renderRequest.setAttribute("eventCount" , eventCount);
    }

}