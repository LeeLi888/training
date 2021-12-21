package com.amf.event.monitor.internal.security.permission.resource.definition;

import com.amf.event.monitor.constants.EventConstants;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
        immediate = true,
        service = PortletResourcePermissionDefinition.class
)
public class EventPortletResourcePermissionDefinition
        implements PortletResourcePermissionDefinition {

    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {

        return new PortletResourcePermissionLogic[] {
                new StagedPortletPermissionLogic(
                        _stagingPermission,
                        "com_amf_event_monitor_web_AmfEventMonitorPortlet")
        };
    }

    @Override
    public String getResourceName() {

        return EventConstants.RESOURCE_NAME;
    }

    @Reference
    private StagingPermission _stagingPermission;

}