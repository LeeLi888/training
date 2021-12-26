package com.amf.user.profile.web.internal.security.permission.resource;

import com.amf.user.profile.model.MovieInterest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = MovieInterestPermission.class
)
public class MovieInterestPermission {

    private static ModelResourcePermission<MovieInterest> modelResourcePermission;

    @Reference(
        target = "(model.class.name=com.amf.user.profile.model.MovieInterest)",
        unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<MovieInterest> _modelResourcePermission) {
        modelResourcePermission = _modelResourcePermission;
    }

    public static boolean contains(
            PermissionChecker permissionChecker, MovieInterest movieInterest,
            String actionId)
            throws PortalException {

        return modelResourcePermission.contains(permissionChecker, movieInterest, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long movieInterestId, String actionId)
            throws PortalException {
        return modelResourcePermission.contains(permissionChecker, movieInterestId, actionId);
    }


}
