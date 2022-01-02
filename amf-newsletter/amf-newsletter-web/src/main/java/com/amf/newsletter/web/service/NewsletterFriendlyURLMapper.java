package com.amf.newsletter.web.service;

import com.amf.newsletter.web.constants.AmfNewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER
        },
        service = FriendlyURLMapper.class
)
public class NewsletterFriendlyURLMapper extends DefaultFriendlyURLMapper {
        @Override
        public String getMapping() {
                return _MAPPING;
        }

        private static final String _MAPPING = "article-issue";
}
