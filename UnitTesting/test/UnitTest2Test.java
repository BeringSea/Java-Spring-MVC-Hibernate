import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by David on 2017-10-01.
 */
public class UnitTest2Test {

    @Test
    public void test2 (){
        UnitTest2 test2 = new UnitTest2();
        String result = test2.stringExample("David","Mojicevic");
        assertEquals("DavidMojicevic",result);
    }

}
