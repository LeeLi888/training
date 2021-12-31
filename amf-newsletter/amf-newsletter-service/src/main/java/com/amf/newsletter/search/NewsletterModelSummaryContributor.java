package com.amf.newsletter.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.amf.newsletter.model.Newsletter",
        service = ModelSummaryContributor.class
)
public class NewsletterModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {

        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
    }

    private Summary createSummary(Document document) {
        String title = document.get(StringBundler.concat(Field.SNIPPET, StringPool.UNDERLINE, Field.TITLE), Field.TITLE);
        String description = document.get(StringBundler.concat(Field.SNIPPET, StringPool.UNDERLINE, Field.DESCRIPTION), Field.DESCRIPTION);

//        return new Summary(title, StringPool.BLANK);
        return new Summary(title, description);
    }

}