package com.genesis.store;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.genesis.store.controllers.HomeControllerTest;
import com.genesis.store.controllers.StoreControllerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ GenesisSpringBootBookStoreApplicationTests.class, StoreControllerTest.class,
		HomeControllerTest.class
})

public class BookStoreAppplicationSuite {

}
