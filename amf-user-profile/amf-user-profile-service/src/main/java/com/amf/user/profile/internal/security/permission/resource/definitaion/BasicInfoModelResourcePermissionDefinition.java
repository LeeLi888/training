package com.amf.user.profile.internal.security.permission.resource.definitaion;

import com.amf.user.profile.constants.UserProfileConstants;
import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.service.BasicInfoLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;

@Component(
        immediate = true,
        service = ModelResourcePermissionDefinition.class
)
public class BasicInfoModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<BasicInfo> {

    @Reference
    private BasicInfoLocalService basicInfoLocalService;

    @Reference
    private GroupLocalService groupLocalService;

    @Reference(target = "(resource.name=" + UserProfileConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission portletResourcePermission;

    @Reference
    private StagingPermission stagingPermission;

    @Reference
    private WorkflowPermission workflowPermission;

    @Override
    public BasicInfo getModel(long primaryKey) throws PortalException {
        return basicInfoLocalService.getBasicInfo(primaryKey);
    }

    @Override
    public Class<BasicInfo> getModelClass() {
        return BasicInfo.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(BasicInfo basicInfo) {
        return basicInfo.getUserId();
    }

    @Override
    public void registerModelResourcePermissionLogics(
            ModelResourcePermission<BasicInfo> modelResourcePermission, Consumer<ModelResourcePermissionLogic<BasicInfo>> modelResourcePermissionLogicConsumer) {

        modelResourcePermissionLogicConsumer.accept(
                new StagedModelPermissionLogic<>(
                        stagingPermission,
                        "com_amf_user_profile_web_AmfUserProfilePortlet",
                        BasicInfo::getUserId));
    }

}
