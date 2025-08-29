package com.unidungeon.test;

import junit.framework.TestSuite;

public class GameTest extends TestSuite {

  public static TestSuite suite() {
    TestSuite testSuite = new TestSuite();
    testSuite.addTestSuite(AnswerTest.class);
    testSuite.addTestSuite(BackpackTest.class);
    testSuite.addTestSuite(BattleModelTest.class);
    testSuite.addTestSuite(BossBattleModelTest.class);
    testSuite.addTestSuite(BossTest.class);
    testSuite.addTestSuite(ItemCompositeTest.class);
    testSuite.addTestSuite(ItemHpTest.class);
    testSuite.addTestSuite(ItemReviveTest.class);
    testSuite.addTestSuite(ItemSpTest.class);
    testSuite.addTestSuite(MobBuilderTest.class);
    testSuite.addTestSuite(MobTest.class);
    testSuite.addTestSuite(PlayerBuilderTest.class);
    testSuite.addTestSuite(PlayerMovingTest.class);
    testSuite.addTestSuite(PlayerTest.class);
    testSuite.addTestSuite(QuestionTest.class);
    testSuite.addTestSuite(QuestionBuilderTest.class);
    return testSuite;
  }
}
