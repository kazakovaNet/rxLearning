import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

class Test1 {
    static <T> void subscribe(T x) {
        Disposable just = just(x).subscribe(x1 -> System.out.println("just: " + x1));

        Disposable never = never().subscribe(x2 -> System.out.println("never"));

        Disposable never1 = Observable.never().subscribe(x3 -> System.out.println("never1"));
    }

    private static <T> Observable<T> just(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onComplete();
        });
    }

    private static <T> Observable<T> never() {
        return Observable.create(subscriber -> {
        });
    }

    private static <T> Observable<T> empty(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onComplete();
        });
    }

    private static <T> Observable<T> range(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onComplete();
        });
    }
}
