package com.aminhjz.interview.urlshortener;

import com.aminhjz.interview.urlshortener.utils.Base62Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Base62UtilsTest {

    @Test
    public void testBase62Encoder(){
        Assertions.assertEquals("a", Base62Utils.to(0l));
        Assertions.assertEquals("r5", Base62Utils.to(1111l));
        Assertions.assertEquals("Gho", Base62Utils.to(123456l) );
        Assertions.assertEquals("I9pfJMFp", Base62Utils.to(123213535345345l));
        Assertions.assertEquals("gVKJn", Base62Utils.to(99999999l));
        Assertions.assertEquals("eJ7IVObQG", Base62Utils.to(1000000000000000l));
        Assertions.assertEquals("k9viXaIfiWh", Base62Utils.to(Long.MAX_VALUE));
    }

    @Test
    public void testBase62EncoderDecoder(){
        Assertions.assertEquals(0l, Base62Utils.from("a"));
        Assertions.assertEquals(1111l, Base62Utils.from("r5"));
        Assertions.assertEquals(123456l,Base62Utils.from("Gho")  );
        Assertions.assertEquals(123213535345345l, Base62Utils.from("I9pfJMFp"));
        Assertions.assertEquals(99999999l, Base62Utils.from("gVKJn"));
        Assertions.assertEquals(1000000000000000l, Base62Utils.from("eJ7IVObQG"));
        Assertions.assertEquals(Long.MAX_VALUE, Base62Utils.from("k9viXaIfiWh"));
    }
}
