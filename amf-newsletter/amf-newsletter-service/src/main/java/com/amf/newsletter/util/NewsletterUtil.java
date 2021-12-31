package com.amf.newsletter.util;

import com.amf.newsletter.constants.ContentType;
import com.amf.newsletter.service.exception.NodeNotExistException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

public class NewsletterUtil {

    private static final String NODE_KEY_ISSUE_NUMBER = "Numeric56413061";

    private static final String NODE_KEY_CONTENT_TYPE = "SingleSelection25916814";

    private static final String NODE_KEY_CONTENT = "content";

    public static long getIssueNumber(String xmlDocContent) throws DocumentException, NodeNotExistException {
        return getIssueNumber(SAXReaderUtil.read(xmlDocContent));
    }

    public static long getIssueNumber(Document document) throws DocumentException, NodeNotExistException {
        Node node = getNodeByName(document, NODE_KEY_ISSUE_NUMBER);

        return Long.parseLong(node.getText());
    }

    public static int getContentType(String xmlDocContent) throws DocumentException, NodeNotExistException {
        return getContentType(SAXReaderUtil.read(xmlDocContent));
    }

    public static int getContentType(Document document) throws DocumentException, NodeNotExistException {
        Node node = getNodeByName(document, NODE_KEY_CONTENT_TYPE);

        String text = node.getText();
        if ("Option57597686".equals(text)) {
            return ContentType.Newsletter;
        } else if ("Option61397390".equals(text)) {
            return ContentType.Article;
        }
        return -1;
    }

    public static String getContent(Document document) throws DocumentException, NodeNotExistException {
        Node node = document.selectSingleNode("/root/dynamic-element/dynamic-element[@name='" + NODE_KEY_CONTENT + "']/dynamic-content");

        return node.getText();
    }

    public static Node getNodeByName(String xmlDoc, String nodeName) throws DocumentException, NodeNotExistException {
        Document doc = SAXReaderUtil.read(xmlDoc);

        return getNodeByName(doc, nodeName);
    }

    public static Node getNodeByName(Document doc, String nodeName) throws DocumentException, NodeNotExistException {
        Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + nodeName + "']/dynamic-content");

        if (node == null) {
            throw new NodeNotExistException();
        }

        return node;
    }
}
