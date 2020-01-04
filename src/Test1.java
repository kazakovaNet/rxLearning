import rx.Observable;
import rx.Observer;

class Test1 {
    static <T> void subscribe(int x) {
        just(x).subscribe(x1 -> System.out.println("just: " + x1));

        never().subscribe(x2 -> System.out.println("never"));

        empty().subscribe(x3 -> {
        }, e -> {
        }, () -> System.out.println("empty"));

        range(x, x).subscribe(x4 -> System.out.println("range: " + x4));
    }

    private static <T> Observable<T> just(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onCompleted();
        });
    }

    private static <T> Observable<T> never() {
        return Observable.create(subscriber -> {
        });
    }

    private static <T> Observable<T> empty() {
        return Observable.create(Observer::onCompleted);
    }

    private static <T> Observable<Integer> range(int from, int n) {
        return Observable.create(subscriber -> {
            for (int i = from; i < from + n; i++) {
                subscriber.onNext(i);
            }

            subscriber.onCompleted();
        });
    }
}
