
import rx.Observable;
import rx.subscriptions.Subscriptions;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

class Test2 {

    static void run() {
        delayed("Hi").subscribe(System.out::println);
    }

    static <T> Observable<T> delayed(T x) {
        return Observable.create(
                subscriber -> {
                    Runnable r = () -> {
                        sleep(10, SECONDS);

                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(x);
                            subscriber.onCompleted();
                        }
                    };

                    final Thread thread = new Thread(r);
                    thread.start();

                    subscriber.add(Subscriptions.create(thread::interrupt));
                });
    }

    private static void sleep(int timeout, TimeUnit unit) {
        try {
            unit.sleep(timeout);
        } catch (InterruptedException ignored) {
            // Сознательно игнорируем
        }
    }
}
