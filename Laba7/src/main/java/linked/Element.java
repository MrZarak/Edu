package linked;

public class Element<T> {
    T t;
    Element<T> next;

    public Element(T t) {
        this.t = t;
    }
}