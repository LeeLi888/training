package com.amf.user.profile.web.portlet.action;

import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.service.FavoriteGenreServiceUtil;
import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;
import com.amf.user.profile.web.constants.MVCCommandNames;
import com.amf.user.profile.web.model.UserProfile;
import com.amf.user.profile.web.service.UserProfileServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author liferay
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AmfUserProfilePortletKeys.AMFUSERPROFILE,
        "mvc.command.name=" + MVCCommandNames.PROFILE_ACTION_UPDATE
    },
    service = MVCActionCommand.class
)
public class UserProfileUpdateMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                UserProfile.class.getName(), actionRequest);

        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();

        long userId = ParamUtil.getLong(actionRequest, "userId");
        String firstName = ParamUtil.getString(actionRequest, "firstName", "");
        String lastName = ParamUtil.getString(actionRequest, "lastName", "");
        boolean male = ParamUtil.getInteger(actionRequest, "gender", 0) == 0;
        int b_year = ParamUtil.getInteger(actionRequest, "b_year");
        int b_month = ParamUtil.getInteger(actionRequest, "b_month");
        int b_day = ParamUtil.getInteger(actionRequest, "b_day");
        String aboutMe = ParamUtil.getString(actionRequest, "aboutMe", "");
        String favoriteQuotes = ParamUtil.getString(actionRequest, "favoriteQuotes", "");
        String favoriteMovie = ParamUtil.getString(actionRequest, "favoriteMovie", "");
        long favoriteGenreId = ParamUtil.getLong(actionRequest, "favoriteGenreId");
        String leastFavoriteMovie = ParamUtil.getString(actionRequest, "leastFavoriteMovie", "");
        String favoriteActor = ParamUtil.getString(actionRequest, "favoriteActor", "");

        Date birtyday = _parse2Date(b_year, b_month, b_day);

        UserProfileServiceUtil.updateUserProfile(
                userId,
                firstName,
                lastName,
                male,
                birtyday,
                aboutMe,
                favoriteQuotes,
                favoriteMovie,
                favoriteGenreId,
                leastFavoriteMovie,
                favoriteActor,
                serviceContext
        );

//        PortalUtil.copyRequestParameters(actionRequest, actionResponse);
//        MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
//        renderParameters.setValue("jspPage", "/profile/view.jsp");
    }

    //parse date
    private Date _parse2Date(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, 0,0,0);
        return cal.getTime();
    }

}