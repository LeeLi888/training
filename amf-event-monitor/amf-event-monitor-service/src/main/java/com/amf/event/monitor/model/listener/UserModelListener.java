package com.amf.event.monitor.model.listener;

import com.amf.event.monitor.constants.EventType;
import com.amf.event.monitor.model.Event;
import com.amf.event.monitor.service.EventLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ResourceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(
    immediate = true,
    service = ModelListener.class
)
public class UserModelListener extends BaseModelListener<User> {

    @Reference
    private EventLocalService eventLocalService;

    @Reference
    protected CounterLocalService counterLocalService;

    @Reference
    protected ResourceLocalService resourceLocalService;

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        System.out.println("#------onAfterCreate------");
        //signup
        long eventId = counterLocalService.increment(Event.class.getName());
        Event event = eventLocalService.createEvent(eventId);
        event.setCompanyId(user.getCompanyId());
        event.setUserId(user.getUserId());
        event.setUserName(user.getScreenName());
        event.setEventType(EventType.Registration);
        event.setClientIp("0.0.0.0");
        event.setCreateDate(new Date());
        eventLocalService.addEvent(event);

        boolean portletActions = false;
        boolean addGroupPermissions = true;
        boolean addGuestPermissions = true;

        super.onAfterCreate(user);
    }

    @Override
    public void onAfterUpdate(User before, User after) throws ModelListenerException {
        //@See LoginPostAction
        super.onAfterUpdate(before, after);
    }

}
