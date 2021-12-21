package com.amf.event.monitor.web.internal.security.permission.resource;

 import com.amf.event.monitor.model.Event;
 import com.liferay.portal.kernel.exception.PortalException;
 import com.liferay.portal.kernel.security.permission.PermissionChecker;
 import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

 import org.osgi.service.component.annotations.Component;
 import org.osgi.service.component.annotations.Reference;

 /**
  * @author liferay
  */
 @Component(
     immediate = true, 
     service = EventPermission.class
 )
 public class EventPermission {

     private static ModelResourcePermission<Event> _eventModelResourcePermission;

     @Reference(
             target = "(model.class.name=com.amf.event.monitor.model.Event)",
             unbind = "-"
     )
     protected void setEntryModelPermission(
             ModelResourcePermission<Event> modelResourcePermission) {

         _eventModelResourcePermission = modelResourcePermission;
     }

     public static boolean contains(
             PermissionChecker permissionChecker, Event event,
             String actionId)
         throws PortalException {

         return _eventModelResourcePermission.contains(
             permissionChecker, event, actionId);
     }

     public static boolean contains(
             PermissionChecker permissionChecker, long assignmentId, String actionId)
         throws PortalException {

         return _eventModelResourcePermission.contains(
             permissionChecker, assignmentId, actionId);
     }


 }