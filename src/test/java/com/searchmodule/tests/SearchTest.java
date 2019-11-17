package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Tests.BaseTest;
import com.searchmodule.pages.SearchPage;

public class SearchTest extends BaseTest {

	@Test
	@Parameters("keyword")
	public void search(String keyword) throws InterruptedException {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int resultCount = searchPage.videoLinkCount();

		Assert.assertTrue(resultCount > 0);
	}

}
