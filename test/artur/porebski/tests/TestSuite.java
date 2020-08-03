package artur.porebski.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestNormalSituations.class,
    TestBorderSituations.class,
    TestAbnormalSituations.class,
})
public class TestSuite {
}