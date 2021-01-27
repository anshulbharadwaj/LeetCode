package thread;

import com.practice.concepts.thread.SynchronizedMethod;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SynchronizedMethodTest {

    @Test
    @SneakyThrows
    /**
     *  This method test usage of synchronized keyword
     *  when calculate method is not synchronized, test case fails everytime
     *  Once synchronized keyword is used with method,test case passes.
     */
    public void test_givenMultiThread_when_non_sync_method() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
        IntStream.range(0,1000)
                .forEach(count -> service.submit(synchronizedMethod::calculate));

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000,synchronizedMethod.getSum());
    }
}
