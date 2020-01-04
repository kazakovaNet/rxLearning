import rx.Subscriber;

import java.io.ObjectInputFilter;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Flow;

public class LazyTwitterObservable {
    private final Set<Subscriber<? super ObjectInputFilter.Status>> subscribers=
            new CopyOnWriteArraySet<>();

//    private final
}
