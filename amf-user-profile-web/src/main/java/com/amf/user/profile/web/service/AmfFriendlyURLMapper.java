package com.amf.user.profile.web.service;

import com.amf.user.profile.web.constants.AmfUserProfilePortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + AmfUserProfilePortletKeys.AMFUSERPROFILE
        },
        service = FriendlyURLMapper.class
)
public class AmfFriendlyURLMapper extends DefaultFriendlyURLMapper {
        @Override
        public String getMapping() {
                return _MAPPING;
        }

        private static final String _MAPPING = "profile";
}
