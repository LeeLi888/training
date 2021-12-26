package com.amf.user.profile.web.portlet.action;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.FavoriteGenreServiceUtil;
import com.amf.user.profile.web.constants.AmfActionKeys;
import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;
import com.amf.user.profile.web.constants.AmfUserProfilePrivacy;
import com.amf.user.profile.web.constants.MVCCommandNames;
import com.amf.user.profile.web.model.UserProfile;
import com.amf.user.profile.web.service.UserProfileServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
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
        "mvc.command.name=" + MVCCommandNames.PROFILE_ACTION_PRIVACY
    },
    service = MVCActionCommand.class
)
public class UserProfilePrivacyMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        long userId = ParamUtil.getLong(actionRequest, "userId");

        int privacyBasicInfo = ParamUtil.getInteger(actionRequest, "privacyBasicInfo", AmfUserProfilePrivacy.PRIVATE);
        int privacyGeneralProfile = ParamUtil.getInteger(actionRequest, "privacyGeneralProfile", AmfUserProfilePrivacy.PRIVATE);
        int privacyMovieInterest = ParamUtil.getInteger(actionRequest, "privacyMovieInterest", AmfUserProfilePrivacy.PRIVATE);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
        UserProfile userProfile = UserProfileServiceUtil.getUserProfile(userId, serviceContext);

        // save permission
        _savePrivacy(companyId, groupId, userProfile, privacyBasicInfo, privacyGeneralProfile, privacyMovieInterest);

//        SessionMessages.add(actionRequest, "privacy-updated");
//        MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
//        renderParameters.setValue("mvcRenderCommandName", MVCCommandNames.PROFILE_PRIVACY);
    }

    // save permission setting
    private void _savePrivacy(long companyId, long groupId, UserProfile userProfile,
                              int privacyBasicInfo, int privacyGeneralProfile, int privacyMovieInterest) throws PortalException {

        UserProfileServiceUtil.savePrivacyForEntity(
                privacyBasicInfo,
                BasicInfo.class.getName(),
                userProfile.getBasicInfo().getPrimaryKeyObj().toString(),
                companyId,
                groupId,
                userProfile.getBasicInfo().getUserId(),
                AmfActionKeys.VIEW_BASIC_INFO
        );

        UserProfileServiceUtil.savePrivacyForEntity(
                privacyGeneralProfile,
                GeneralProfile.class.getName(),
                userProfile.getGeneralProfile().getPrimaryKeyObj().toString(),
                companyId,
                groupId,
                userProfile.getBasicInfo().getUserId(),
                AmfActionKeys.VIEW_GENERAL_PROFILE
        );

        UserProfileServiceUtil.savePrivacyForEntity(
                privacyMovieInterest,
                MovieInterest.class.getName(),
                userProfile.getMovieInterest().getPrimaryKeyObj().toString(),
                companyId,
                groupId,
                userProfile.getBasicInfo().getUserId(),
                AmfActionKeys.VIEW_MOVIE_INTEREST
        );

    }

}