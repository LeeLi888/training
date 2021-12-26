package com.amf.user.profile.web.portlet.action;

import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.service.FavoriteGenreServiceUtil;
import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;
import com.amf.user.profile.web.constants.MVCCommandNames;
import com.amf.user.profile.web.model.UserProfile;
import com.amf.user.profile.web.service.UserProfileServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

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
        "mvc.command.name=" + MVCCommandNames.PROFILE_EDIT
    },
    service = MVCRenderCommand.class
)
public class UserProfileEditMVCRenderCommand implements MVCRenderCommand {

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

        } catch (PortalException e) {
            throw new PortletException(e);
        }

        List<FavoriteGenre> genres = FavoriteGenreServiceUtil.getFavoriteGenres();
        renderRequest.setAttribute("genres", genres);

        renderRequest.setAttribute("screenName", screenName);

        return "/profile/edit.jsp";
    }


}