package com.amf.event.monitor.model.lifecycle.action;

import com.amf.event.monitor.constants.EventType;
import com.amf.event.monitor.model.Event;
import com.amf.event.monitor.service.EventLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component(
    immediate = true,
    property = {
            "key=login.events.post"
    },
    service = LifecycleAction.class
)
public class LoginPostAction implements LifecycleAction {

    @Reference
    private EventLocalService eventLocalService;

    @Reference
    protected CounterLocalService counterLocalService;

    @Reference
    protected ResourceLocalService resourceLocalService;

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
        System.out.println("#------Login post------");

        HttpServletRequest request = lifecycleEvent.getRequest();
        try {
            User user = PortalUtil.getUser(request);

            long eventId = counterLocalService.increment(Event.class.getName());
            Event event = eventLocalService.createEvent(eventId);
            event.setCompanyId(user.getCompanyId());
            event.setUserId(user.getUserId());
            event.setUserName(user.getScreenName());
            event.setEventType(EventType.Login);
            event.setClientIp(request.getRemoteAddr());
            event.setCreateDate(new Date());
            eventLocalService.addEvent(event);

            boolean portletActions = false;
            boolean addGroupPermissions = true;
            boolean addGuestPermissions = true;

        } catch (PortalException e) {
            throw new ActionException(e);
        }
    }
}
