package kr.personal.cjh.tdd.practice.tyrant;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TyrantTest {
    @Test
    public void getRetrievesWhatWasPut() throws IOException {
//        Tyrant tyrant = new Tyrant();
//        tyrant.put("key", "value");
//        assertThat(tyrant.get("key"), is("value"));

        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.open();
        tyrantMap.put("key", "value");
        assertThat(tyrantMap.get("key"), is("value"));
        tyrantMap.close();
    }

}
