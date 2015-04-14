/*
 Copyright (c) 2015 Red Hat, Inc.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are
 met:

   1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

   2. Redistributions in binary form must reproduce the above
   copyright notice, this list of conditions and the following
   disclaimer in the documentation and/or other materials provided
   with the distribution.

 THIS SOFTWARE IS PROVIDED BY RED HAT, INC. ``AS IS'' AND ANY EXPRESS
 OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL RED HAT, INC. BE LIABLE FOR ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.
 */

package com.redhat.training.ui.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchResultsPage {

	@FindBy(id = "searchFlight_header")
	private WebElement tableHeader;

	@FindBy(className = "rf-dt")
	private WebElement resultsTable;

	public boolean isOnPage() {
		try {
			return tableHeader.getText().equals("Flight Search Results");
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void selectFlight(int flight) {
		try {
			WebElement selection = resultsTable.findElement(By
					.xpath("//tbody/tr[" + flight + "]/td/form/a"));
			Graphene.guardHttp(selection).click();
		} catch (NoSuchElementException e) {
			Assert.fail("No flight results found, please check search date.");
			System.out.println(e.getMessage());
		}

	}
}