package linked;

import java.util.*;
import java.util.function.Consumer;



public class MyBestOneLinkedList<T> implements List<T> {
    Element<T> first;

    int size = 0;

    public MyBestOneLinkedList() {

    }

    public MyBestOneLinkedList(T object) {
        add(object);
    }

    public MyBestOneLinkedList(Collection<T> collection) {
        addAll(collection);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Element<T> current = first;
        while (current != null) {
            if (current.t == o)
                return true;
            current = current.next;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        int c = 0;
        Element<T> current = first;
        while (current != null) {
            objects[c] = current.t;
            current = current.next;
            c++;
        }
        return objects;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        E[] objects = (E[]) new Object[size()];
        int c = 0;
        Element<T> current = first;
        while (current != null) {
            objects[c] = (E) current.t;
            current = current.next;
            c++;
        }
        return objects;
    }

    @Override
    public boolean add(T t) {
        if (first == null) {
            first = new Element<>(t);
        } else {
            Element<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Element<>(t);
        }
        size += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == first.t) {
            clear();
            return true;
        }
        Element<T> prev = null;
        Element<T> current = first;
        while (current != null) {
            if (current.t == o) {
                size -= 1;
                if (prev != null)
                    prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T e : c) {
            add(index, e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object e : c) {
            remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object e : c) {
            if (contains(e)) {
                remove(e);
            }
        }
        return true;
    }


    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int c = 0;
        Element<T> current = first;
        while (current != null) {
            if (c == index) {
                return current.t;
            }
            current = current.next;
            c++;
        }
        return null;
    }

    @Override
    public T set(int index, T t) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Element<T> prev = first;
            first = new Element<>(t);
            return prev.t;
        }

        int c = 0;
        Element<T> prev = null;
        Element<T> current = first;
        while (current != null) {
            if (c == index) {
                Element<T> element = new Element<>(t);
                prev.next = element;
                element.next = current.next;
                return current.t;
            }
            prev = current;
            current = current.next;
            c++;
        }
        return null;
    }

    @Override
    public void add(int index, T t) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Element<T> element = new Element<>(t);
            element.next = first;
            first = element;
            size += 1;
            return;
        }
        int c = 0;
        Element<T> prev = null;
        Element<T> current = first;
        while (current != null) {
            if (c == index) {
                Element<T> element = new Element<>(t);
                prev.next = element;
                element.next = current;
                size += 1;
                break;
            }
            prev = current;
            current = current.next;
            c++;
        }
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Element<T> prev = first;
            first = prev.next;
            size -= 1;
            return prev.t;
        }
        int c = 0;
        Element<T> prev = null;
        Element<T> current = first;
        while (current != null) {
            if (c == index) {
                prev.next = current.next;
                size -= 1;
                return current.t;
            }
            prev = current;
            current = current.next;
            c++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int c = 0;
        Element<T> current = first;
        while (current != null) {
            if (current.t == o) {
                return c;
            }
            current = current.next;
            c++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastFinded = -1;
        int c = 0;
        Element<T> current = first;
        while (current != null) {
            if (current.t == o) {
                lastFinded = c;
            }
            current = current.next;
            c++;
        }
        return lastFinded;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);
    }

    @Override
    public MyBestOneLinkedList<T> subList(int fromIndex, int toIndex) {
        MyBestOneLinkedList<T> sub = new MyBestOneLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(get(i));
        }
        return sub;
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            T e = it.next();
            sb.append(e == this ? "(this)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    class Itr implements Iterator<T> {
        int index = 0;

        public boolean hasNext() {
            return index != size;
        }

        public T next() {
            index++;

            return get(index - 1);
        }

        public void remove() {
            index++;
        }

        public void forEachRemaining(Consumer<? super T> consumer) {
            Element<T> current = first;
            while (current != null) {
                consumer.accept(current.t);
                current = current.next;
            }
        }
    }

    private class ListItr extends Itr implements ListIterator<T> {
        ListItr(int index) {
            super();
            this.index = index;
        }

        @Override
        public boolean hasPrevious() {
            return index != 0;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public T previous() {
            int i = previousIndex();
            if (i < 0)
                throw new NoSuchElementException();
            if (i >= size)
                throw new ConcurrentModificationException();

            return get(i);
        }

        @Override
        public void set(T e) {
            if (previousIndex() < 0)
                throw new IllegalStateException();

            try {
                MyBestOneLinkedList.this.set(previousIndex(), e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(T e) {
            if (previousIndex() < 0)
                throw new IllegalStateException();
            try {
                MyBestOneLinkedList.this.add(previousIndex(), e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
