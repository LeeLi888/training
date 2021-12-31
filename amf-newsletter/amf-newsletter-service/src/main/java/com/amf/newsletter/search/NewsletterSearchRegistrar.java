package com.amf.newsletter.search;

import com.amf.newsletter.model.Newsletter;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class NewsletterSearchRegistrar {

    @Reference(target = "(indexer.class.name=com.amf.newsletter.model.Newsletter)")
    protected ModelIndexerWriterContributor<Newsletter> modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=com.amf.newsletter.model.Newsletter)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> serviceRegistration;

    @Activate
    protected void activate(BundleContext bundleContext) {
        serviceRegistration = modelSearchRegistrarHelper.register(
            Newsletter.class, bundleContext, modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK, Field.UID,
                            Field.DESCRIPTION, Field.TITLE);

                    modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
                    modelSearchDefinition.setModelSummaryContributor(modelSummaryContributor);
//                    modelSearchDefinition.setSelectAllLocales(true);
                    modelSearchDefinition.setSearchResultPermissionFilterSuppressed(true);
            });
    }

    @Deactivate
    protected void deactivate() {
        serviceRegistration.unregister();
    }

}
