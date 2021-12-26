package com.amf.registration.web.portlet.action;

import com.amf.registration.exception.AmfRegistrationValidationException;
import com.amf.registration.model.UserExternal;
import com.amf.registration.service.UserExternalService;
import com.amf.registration.web.constants.AmfRegistrationPortletKeys;
import com.amf.registration.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;

/**
 * MVC Action Command for registration.
 *
 * @author Lee
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AmfRegistrationPortletKeys.AMFREGISTRATION,
                "mvc.command.name=" + MVCCommandNames.REGIST_SUBMIT
        },
        service = MVCActionCommand.class
)
public class RegistMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    protected UserExternalService _userExternalService;

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                UserExternal.class.getName(), actionRequest);

//        long groupId = themeDisplay.getScopeGroupId();

        //get parameter from front
        String first_name = ParamUtil.getString(actionRequest, "first_name");
        String last_name = ParamUtil.getString(actionRequest, "last_name");
        String email_address = ParamUtil.getString(actionRequest, "email_address");
        String username = ParamUtil.getString(actionRequest, "username");
        int male = ParamUtil.getInteger(actionRequest, "male");
        int b_year = ParamUtil.getInteger(actionRequest, "b_year");
        int b_month = ParamUtil.getInteger(actionRequest, "b_month");
        int b_day = ParamUtil.getInteger(actionRequest, "b_day");
        String password1 = ParamUtil.getString(actionRequest, "password1");
        String home_phone = ParamUtil.getString(actionRequest, "home_phone");
        String mobile_phone = ParamUtil.getString(actionRequest, "mobile_phone");
        String address1 = ParamUtil.getString(actionRequest, "address1");
        String address2 = ParamUtil.getString(actionRequest, "address2");
        String city = ParamUtil.getString(actionRequest, "city");
        long state = ParamUtil.getLong(actionRequest, "state");
        String zip_code = ParamUtil.getString(actionRequest, "zip_code");
        String security_question = ParamUtil.getString(actionRequest, "security_question");
        String security_answer = ParamUtil.getString(actionRequest, "security_answer");

        try {

            Date birthday = _parse2Date(b_year, b_month, b_day);

            // Call the service
            _userExternalService.addUserExternal(
                    first_name,
                    last_name,
                    email_address,
                    username,
                    male,
                    birthday,
                    password1,
                    home_phone,
                    mobile_phone,
                    address1,
                    address2,
                    city,
                    state,
                    zip_code,
                    security_question,
                    security_answer,
                    serviceContext
            );

            SessionMessages.add(actionRequest, "registed");

            MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
            renderParameters.setValue("mvcRenderCommandName", MVCCommandNames.REGIST_RESULT);

        } catch (AmfRegistrationValidationException ave) {

            // Get error messages from the service layer.
            ave.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

            MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
            renderParameters.setValue("mvcRenderCommandName", MVCCommandNames.REGIST_FORM);

        } catch (Exception pe) {

            pe.printStackTrace();

            // Set error messages from the service layer.
            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
            renderParameters.setValue("mvcRenderCommandName", MVCCommandNames.REGIST_FORM);
        }
    }

    //parse date
    private Date _parse2Date(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, 0,0,0);
        return cal.getTime();
    }

}
