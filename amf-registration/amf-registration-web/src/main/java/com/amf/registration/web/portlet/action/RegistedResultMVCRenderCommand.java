package com.amf.registration.web.portlet.action;

 import com.amf.registration.web.constants.AmfRegistrationPortletKeys;
 import com.amf.registration.web.constants.MVCCommandNames;
 import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

 import javax.portlet.PortletException;
 import javax.portlet.RenderRequest;
 import javax.portlet.RenderResponse;

 import org.osgi.service.component.annotations.Component;

 /**
  * MVC Command for showing edit assignment view.
  * 
  * @author liferay
  */
 @Component(
     immediate = true,
     property = {
         "javax.portlet.name=" + AmfRegistrationPortletKeys.AMFREGISTRATION,
         "mvc.command.name=" + MVCCommandNames.REGIST_RESULT
     }, 
     service = MVCRenderCommand.class
 )
 public class RegistedResultMVCRenderCommand implements MVCRenderCommand {

     @Override
     public String render(
         RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException {

         return "/regist/result.jsp";
     }


 }