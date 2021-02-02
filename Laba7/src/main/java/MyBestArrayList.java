import java.util.*;
import java.util.function.Consumer;

public class MyBestArrayList<E> implements List<E> {
    static int INITIAL_SIZE = 15;
    static int MAX_SIZE = (int) (INITIAL_SIZE + INITIAL_SIZE * 0.3F);
    Object[] array = new Object[INITIAL_SIZE];
    int size = 0;

    public MyBestArrayList() {

    }

    public MyBestArrayList(E object) {
        add(object);
    }

    public MyBestArrayList(Collection<E> collection) {
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
        for (Object o1 : array) {
            if (o1 == o)
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, size);
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index < size) {
            if (size == INITIAL_SIZE) {
                array = Arrays.copyOf(array, MAX_SIZE);
            } else if (size == MAX_SIZE) {
                throw new IndexOutOfBoundsException("Досягнули максимального розміру List`a");
            }
            size += 1;
            Object[] old = array;
            array = new Object[old.length];
            System.arraycopy(old, 0, array, 0, index);
            array[index] = element;
            System.arraycopy(old, index, array, index + 1, size - index - 1);
        } else
            throw new IndexOutOfBoundsException("Досягнули максимального розміру List`a");
    }

    @Override
    public boolean add(E e) {
        if (size == INITIAL_SIZE) {
            array = Arrays.copyOf(array, MAX_SIZE);
        } else if (size == MAX_SIZE) {
            throw new IndexOutOfBoundsException("Досягнули максимального розміру List`a");
        }
        array[size] = e;
        size += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == o) {
                pos = i;
                break;
            }
        }
        if (pos == -1)
            return false;
        size -= 1;
        Object[] old = array;
        array = size >= INITIAL_SIZE ? new Object[MAX_SIZE] : new Object[INITIAL_SIZE];
        if (pos > 0) {
            System.arraycopy(old, 0, array, 0, pos);
        }
        if (size > 0) {
            System.arraycopy(old, pos + 1, array, pos, size - pos);
        }
        return true;
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
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e : c) {
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
        array = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < size) {
            array[index] = element;
            return element;
        }
        return null;
    }


    @Override
    public E remove(int index) {
        if (index < size) {
            E element = (E) array[index];
            remove(element);
            return element;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == o)
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    @Override
    public MyBestArrayList<E> subList(int fromIndex, int toIndex) {
        MyBestArrayList<E> sub = new MyBestArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(get(i));
        }
        return sub;
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            E e = it.next();
            sb.append(e == this ? "(this)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    class Itr implements Iterator<E> {
        int index = 0;

        public boolean hasNext() {
            return index != size;
        }

        public E next() {
            index++;
            return (E) array[index - 1];
        }

        public void remove() {
            index++;
        }

        public void forEachRemaining(Consumer<? super E> consumer) {
            for (Object o : array) {
                if (o != null) {
                    consumer.accept((E) o);
                }
            }
        }
    }

    private class ListItr extends Itr implements ListIterator<E> {
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
        public E previous() {
            int i = previousIndex();
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = array;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            return (E) elementData[i];
        }

        @Override
        public void set(E e) {
            if (previousIndex() < 0)
                throw new IllegalStateException();

            try {
                MyBestArrayList.this.set(previousIndex(), e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(E e) {
            if (previousIndex() < 0)
                throw new IllegalStateException();
            try {
                MyBestArrayList.this.add(previousIndex(), e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

