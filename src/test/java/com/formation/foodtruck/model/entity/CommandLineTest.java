package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandLineTest {

	@Mock
	private final Article article = Mockito.mock(Article.class);
	@Mock
	private final Command command = Mockito.mock(Command.class);

	@InjectMocks
	private CommandLine commandLineOk = new CommandLine();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		commandLineOk.setArticle(article);
		commandLineOk.setCommand(command);
		commandLineOk.setQuantite(2);
	}

	@Test
	public void testCommandLineOk() {
		try {
			Assert.assertNotNull(commandLineOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testCommandLineCommandNull()
			throws BadAttributeValueExpException {
		final CommandLine commandLineCommandNull = new CommandLine(null,
				article, 10);
		Assert.assertNull(commandLineCommandNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testCommandLineArticleNull()
			throws BadAttributeValueExpException {
		final CommandLine commandLineArticleNull = new CommandLine(command,
				null, 10);
		Assert.assertNull(commandLineArticleNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetCommandNull() throws BadAttributeValueExpException {
		CommandLine commandLineNotOk = commandLineOk;
		commandLineNotOk.setCommand(null);
		Assert.assertNull(commandLineNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		CommandLine commandLineNotOk = commandLineOk;
		commandLineNotOk.setId(null);
		Assert.assertNull(commandLineNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetQuantiteNull() throws BadAttributeValueExpException {
		CommandLine commandLineNotOk = commandLineOk;
		commandLineNotOk.setQuantite(null);
		Assert.assertNull(commandLineNotOk);
	}

	@Test
	public void testSetOk() throws BadAttributeValueExpException {
		CommandLine commandLineValide = commandLineOk;
		commandLineValide.setArticle(article);
		commandLineValide.setCommand(command);
		commandLineValide.setId(5);
	}
}
