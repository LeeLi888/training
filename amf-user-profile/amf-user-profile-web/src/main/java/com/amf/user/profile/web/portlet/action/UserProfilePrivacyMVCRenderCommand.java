package com.amf.user.profile.web.portlet.action;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.FavoriteGenreServiceUtil;
import com.amf.user.profile.web.constants.AmfActionKeys;
import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;
import com.amf.user.profile.web.constants.MVCCommandNames;
import com.amf.user.profile.web.internal.security.permission.resource.BasicInfoPermission;
import com.amf.user.profile.web.internal.security.permission.resource.GeneralProfilePermission;
import com.amf.user.profile.web.internal.security.permission.resource.MovieInterestPermission;
import com.amf.user.profile.web.model.UserProfile;
import com.amf.user.profile.web.service.UserProfileServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
        "javax.portlet.name=" + AmfUserProfilePortletKeys.AMFUSERPROFILE,
        "mvc.command.name=" + MVCCommandNames.PROFILE_PRIVACY
    },
    service = MVCRenderCommand.class
)
public class UserProfilePrivacyMVCRenderCommand implements MVCRenderCommand {

    @Reference
    protected BasicInfoPermission basicInfoPermission;

    @Reference
    protected GeneralProfilePermission generalProfilePermission;

    @Reference
    protected MovieInterestPermission movieInterestPermission;

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

        String screenName = ParamUtil.getString(renderRequest, "screenName", "");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

            User user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);

            UserProfile userProfile = UserProfileServiceUtil.getUserProfile(user.getUserId(), serviceContext);

            renderRequest.setAttribute("userProfile", userProfile);

            List<FavoriteGenre> genres = FavoriteGenreServiceUtil.getFavoriteGenres();
            renderRequest.setAttribute("genres", genres);

//            //get privacy info
//            _getPrivacy(renderRequest, companyId, userProfile);

        } catch (PortalException e) {
            throw new PortletException(e);
        }

        renderRequest.setAttribute("screenName", screenName);

        // Add permission checker.
        renderRequest.setAttribute("basicInfoPermission", basicInfoPermission);
        renderRequest.setAttribute("generalProfilePermission", generalProfilePermission);
        renderRequest.setAttribute("movieInterestPermission", movieInterestPermission);

        return "/profile/privacy.jsp";
    }

//    private void _getPrivacy(RenderRequest renderRequest, long companyId, UserProfile userProfile) throws PortalException {
//        Role roleMember = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
//        Role roleGuest = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
//
//        int privacyBasicInfo =
//                UserProfileServiceUtil.getPrivacy(
//                        AmfActionKeys.VIEW_BASIC_INFO,
//                        BasicInfo.class.getName(),
//                        userProfile.getBasicInfo().getPrimaryKeyObj().toString(),
//                        companyId, roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());
//
//        int privacyGeneralProfile =
//                UserProfileServiceUtil.getPrivacy(
//                        AmfActionKeys.VIEW_GENERAL_PROFILE,
//                        GeneralProfile.class.getName(),
//                        userProfile.getGeneralProfile().getPrimaryKeyObj().toString(),
//                        companyId, roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());
//
//        int privacyMovieInterest =
//                UserProfileServiceUtil.getPrivacy(
//                        AmfActionKeys.VIEW_MOVIE_INTEREST,
//                        MovieInterest.class.getName(),
//                        userProfile.getMovieInterest().getPrimaryKeyObj().toString(),
//                        companyId, roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());
//
//        renderRequest.setAttribute("privacyBasicInfo", privacyBasicInfo);
//        renderRequest.setAttribute("privacyGeneralProfile", privacyGeneralProfile);
//        renderRequest.setAttribute("privacyMovieInterest", privacyMovieInterest);
//    }

}