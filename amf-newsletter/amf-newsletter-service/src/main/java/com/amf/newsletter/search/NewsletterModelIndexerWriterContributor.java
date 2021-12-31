package com.amf.newsletter.search;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.service.NewsletterLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.amf.newsletter.model.Newsletter",
        service = ModelIndexerWriterContributor.class
)
public class NewsletterModelIndexerWriterContributor implements ModelIndexerWriterContributor<Newsletter> {

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

//    @Reference
//    protected ArticleBatchReindexer articleBatchReindexer;

    @Reference
    protected NewsletterLocalService newsletterLocalService;

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (Newsletter newsletter) ->
                        batchIndexingActionable.addDocuments(
                                modelIndexerWriterDocumentHelper.getDocument(
                                        newsletter)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                newsletterLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Newsletter newsletter) {
        return newsletter.getCompanyId();
    }

//    @Override
//    public void modelIndexed(Newsletter newsletter) {
//        articleBatchReindexer.reindex(
//                newsletter.getIssueNumber(), newsletter.getCompanyId());
//    }

}