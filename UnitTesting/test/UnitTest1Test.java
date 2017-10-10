import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by David on 2017-09-30.
 */

public class UnitTest1Test {

    @Test
    public void test(){
        UnitTest1 test = new UnitTest1();
        int result = test.addNumber(2,2);
        assertEquals(4,result);
    }
}
