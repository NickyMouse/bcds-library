package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import java.util.Date;

import org.apache.lucene.document.Document;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;

public class DocumentFactoryTest {

	@Test
	public void testConvert() {
		DocumentFactory df = DocumentFactory.getInstance(BuildBookSearchDO.class, new SimpleConvertObjectHandler());
		BuildBookSearchDO buildBookSearchDO = new BuildBookSearchDO();
		Date now = new Date();
		buildBookSearchDO.setItemAddTime(now);
		
		Document doc = df.convert(buildBookSearchDO);
		Assert.assertNotNull(doc);
	}

}
