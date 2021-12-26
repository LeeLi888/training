package com.amf.user.profile.web.service;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.*;
import com.amf.user.profile.web.constants.AmfActionKeys;
import com.amf.user.profile.web.constants.AmfUserProfilePrivacy;
import com.amf.user.profile.web.model.UserProfile;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.*;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

@Component
public class UserProfileServiceUtil {

    public static UserProfile getUserProfile(long userId, ServiceContext serviceContext) throws PortalException {

        long scCompanyId = serviceContext.getCompanyId();

        UserProfile userProfile = new UserProfile();

        fetchBasicInfo(userProfile, userId, scCompanyId, serviceContext);

        fetchGeneralProfile(userProfile, userId, scCompanyId);

        fetchMovieInterest(userProfile, userId, scCompanyId);

        return userProfile;
    }

    // fetch basic info
    public static void fetchBasicInfo(UserProfile userProfile, long userId, long scCompanyId, ServiceContext serviceContext) throws PortalException {
        //basic info
        BasicInfo basicInfo = BasicInfoServiceUtil.getBasicInfo(userId, serviceContext);
        userProfile.setBasicInfo(basicInfo);

        //get basic info privacy
        if (basicInfo != null) {
            userProfile.setPrivacyBasicInfo(
                    getPrivacy(
                            AmfActionKeys.VIEW_BASIC_INFO,
                            BasicInfo.class.getName(),
                            basicInfo.getPrimaryKey(),
                            scCompanyId
                    )
            );
        } else {
            userProfile.setPrivacyBasicInfo(AmfUserProfilePrivacy.PRIVATE);
        }
    }

    // fetch GeneralProfile info
    public static void fetchGeneralProfile(UserProfile userProfile, long userId, long scCompanyId) throws PortalException {
        //general info
        GeneralProfile generalProfile = GeneralProfileServiceUtil.getGeneralProfileByUserId(userId);
        userProfile.setGeneralProfile(generalProfile);

        //get GeneralProfile info privacy
        if (generalProfile != null) {
            userProfile.setPrivacyGeneralProfile(
                    getPrivacy(
                            AmfActionKeys.VIEW_GENERAL_PROFILE,
                            GeneralProfile.class.getName(),
                            generalProfile.getPrimaryKey(),
                            scCompanyId
                    )
            );
        } else {
            userProfile.setPrivacyGeneralProfile(AmfUserProfilePrivacy.PRIVATE);
        }
    }

    // fetch MovieInterest info
    public static void fetchMovieInterest(UserProfile userProfile, long userId, long scCompanyId) throws PortalException {
        //movie interest
        MovieInterest movieInterest = MovieInterestServiceUtil.getMovieInterestByUserId(userId);
        userProfile.setMovieInterest(movieInterest);

        //get GeneralProfile info privacy
        if (movieInterest != null) {
            userProfile.setPrivacyMovieInterest(
                    getPrivacy(
                            AmfActionKeys.VIEW_MOVIE_INTEREST,
                            MovieInterest.class.getName(),
                            movieInterest.getPrimaryKey(),
                            scCompanyId
                    )
            );
        } else {
            userProfile.setPrivacyMovieInterest(AmfUserProfilePrivacy.PRIVATE);
        }
    }

    public static UserProfile updateUserProfile(
            long userId,
            String firstName,
            String lastName,
            boolean male,
            Date birthDay,
            String aboutMe,
            String favoriteQuotes,
            String favoriteMovie,
            long favoriteGenreId,
            String leastFavoriteMovie,
            String favoriteActor,
            ServiceContext serviceContext) throws PortalException {

        UserProfile userProfile = new UserProfile();

        //basic info
        BasicInfo basicInfo = BasicInfoLocalServiceUtil.updateBasicInfo(userId, firstName, lastName, male, birthDay, serviceContext);
        userProfile.setBasicInfo(basicInfo);

        //general profile
        GeneralProfile generalProfile = GeneralProfileLocalServiceUtil.getGeneralProfileByUserId(userId);
        if (generalProfile == null) {
            generalProfile = GeneralProfileLocalServiceUtil.addGeneralProfile(userId, aboutMe, favoriteQuotes, serviceContext);
        } else {
            generalProfile = GeneralProfileLocalServiceUtil.updateGeneralProfile(generalProfile.getGeneralProfileId(), aboutMe, favoriteQuotes, serviceContext);
        }
        userProfile.setGeneralProfile(generalProfile);

        //movie interest
        MovieInterest movieInterest = MovieInterestLocalServiceUtil.getMovieInterestByUserId(userId);
        if (movieInterest == null) {
            movieInterest = MovieInterestLocalServiceUtil.addMovieInterest(userId, favoriteMovie, favoriteGenreId, leastFavoriteMovie, favoriteActor, serviceContext);
        } else {
            movieInterest = MovieInterestLocalServiceUtil.updateMovieInterest(movieInterest.getMovieInterestId(), favoriteMovie, favoriteGenreId, leastFavoriteMovie, favoriteActor, serviceContext);
        }
        userProfile.setMovieInterest(movieInterest);

        return userProfile;
    }

    public static int getPrivacy(String actionId,
        String className, long primaryKey, long companyId) throws PortalException {

        Role roleMember = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
        Role roleGuest = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
        long roleMemberId = roleMember.getPrimaryKey();
        long roleGuestId = roleGuest.getPrimaryKey();

        int privacy = AmfUserProfilePrivacy.PRIVATE;
        int scopeId = ResourceConstants.SCOPE_INDIVIDUAL;

        ResourcePermission memberPermission = ResourcePermissionLocalServiceUtil
                .fetchResourcePermission(companyId, className, scopeId, String.valueOf(primaryKey), roleMemberId);
        if (memberPermission != null && memberPermission.hasActionId(actionId)) {
            privacy = AmfUserProfilePrivacy.PROTECTED;
        }

        ResourcePermission guestPermission = ResourcePermissionLocalServiceUtil
                .fetchResourcePermission(companyId, className, scopeId, String.valueOf(primaryKey), roleGuestId);
        if (guestPermission != null && guestPermission.hasActionId(actionId)) {
            privacy = AmfUserProfilePrivacy.PUBLIC;
        }

        return privacy;
    }

    public static void savePrivacyForEntity(
            int privacy, String className, String entityPk, long companyId, long groupId, long userId, String actionId) throws PortalException {

        Role roleMember = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
        Role roleGuest = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
        long roleMemberId = roleMember.getPrimaryKey();
        long roleGuestId = roleGuest.getPrimaryKey();

        // first delete permission
        for (int scope : ResourceConstants.SCOPES) {
            ResourcePermissionLocalServiceUtil.removeResourcePermission(
                    companyId, className, scope, String.valueOf(entityPk), roleMemberId, actionId);
            ResourcePermissionLocalServiceUtil.removeResourcePermission(
                    companyId, className, scope, String.valueOf(entityPk), roleGuestId, actionId);
        }

        if (AmfUserProfilePrivacy.PROTECTED == privacy) {
            ResourceLocalServiceUtil.addResources(companyId, groupId, userId, className, entityPk,
                    false, true, false);
        } else if (AmfUserProfilePrivacy.PUBLIC == privacy) {
            ResourceLocalServiceUtil.addResources(companyId, groupId, userId, className, entityPk,
                    false, true, true);
        }
    }


}
